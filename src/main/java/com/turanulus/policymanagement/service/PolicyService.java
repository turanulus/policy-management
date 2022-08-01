package com.turanulus.policymanagement.service;

import com.turanulus.policymanagement.dto.*;
import com.turanulus.policymanagement.exception.PolicyNotFoundException;
import com.turanulus.policymanagement.mapper.InsuredPersonMapper;
import com.turanulus.policymanagement.model.InsuredPerson;
import com.turanulus.policymanagement.model.Policy;
import com.turanulus.policymanagement.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Service
public class PolicyService {

  private final PolicyRepository policyRepository;
  private final InsuredPersonMapper insuredPersonMapper;

  public PolicyCreationResponse create(PolicyCreationReqBody policyBody) {
    Policy policy = new Policy();
    policy.setStartDate(stringToDate(policyBody.getStartDate()));
    policy.setInsuredPersonList(
        insuredPersonMapper.convertToModel(policyBody.getInsuredPersonList()));

    Policy savedPolicy = policyRepository.save(policy);

    return PolicyCreationResponse.builder()
        .policyId(savedPolicy.getId())
        .startDate(dateToString(savedPolicy.getStartDate()))
        .insuredPersonList(policyBody.getInsuredPersonList())
        .totalPremium(calculateTotalPremium(savedPolicy.getInsuredPersonList()))
        .build();
  }

  public PolicyModificationResponse update(PolicyManipulationReqBody policyBody) {
    Policy policy =
        policyRepository
            .findById(policyBody.getPolicyId())
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

    policy.setStartDate(stringToDate(policyBody.getEffectiveDate()));
    policy.getInsuredPersonList().clear();
    policy
        .getInsuredPersonList()
        .addAll(insuredPersonMapper.convertToModel(policyBody.getInsuredPersonList()));
    policy.setStartDate(stringToDate(policyBody.getEffectiveDate()));

    Policy savedPolicy = policyRepository.save(policy);

    return PolicyModificationResponse.builder()
        .policyId(savedPolicy.getId())
        .effectiveDate(dateToString(savedPolicy.getStartDate()))
        .insuredPersonList(policyBody.getInsuredPersonList())
        .totalPremium(calculateTotalPremium(savedPolicy.getInsuredPersonList()))
        .build();
  }

  public PolicyInformationResponse getPolicy(@Valid PolicyInformationReqBody policyBody) {
    Policy policy =
        policyRepository
            .findById(policyBody.getPolicyId())
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

    return PolicyInformationResponse.builder()
        .policyId(policy.getId())
        .requestDate(dateToString(stringToDate(policyBody.getRequestDate())))
        .insuredPersonList(insuredPersonMapper.convertToDTO(policy.getInsuredPersonList()))
        .totalPremium(calculateTotalPremium(policy.getInsuredPersonList()))
        .build();
  }

  private Date stringToDate(String dateInString) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    Date date;
    try {
      date = formatter.parse(dateInString);
    } catch (ParseException e) {
      throw new ValidationException("String format should be dd.MM.yyyy");
    }
    return date;
  }

  private String dateToString(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    return dateFormat.format(date);
  }

  private float calculateTotalPremium(List<InsuredPerson> insuredPersonList) {
    return insuredPersonList.stream()
        .map(insuredPerson -> insuredPerson.getPremium())
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .floatValue();
  }
}
