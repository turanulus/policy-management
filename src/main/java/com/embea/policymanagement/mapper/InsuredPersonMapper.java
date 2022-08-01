package com.embea.policymanagement.mapper;

import com.embea.policymanagement.dto.InsuredPersonDTO;
import com.embea.policymanagement.model.InsuredPerson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InsuredPersonMapper {
  public List<InsuredPersonDTO> convertToDTO(List<InsuredPerson> insuredPersonList) {
    return insuredPersonList.stream()
        .map(
            insuredPerson ->
                InsuredPersonDTO.builder()
                    .firstName(insuredPerson.getFirstName())
                    .secondName(insuredPerson.getSecondName())
                    .premium(insuredPerson.getPremium())
                    .build())
        .collect(Collectors.toList());
  }

  public List<InsuredPerson> convertToModel(List<InsuredPersonDTO> insuredPersonList) {
    return insuredPersonList.stream()
        .map(
            insuredPersonDTO -> {
              InsuredPerson insuredPerson = new InsuredPerson();
              insuredPerson.setFirstName(insuredPersonDTO.getFirstName());
              insuredPerson.setSecondName(insuredPersonDTO.getSecondName());
              insuredPerson.setPremium(insuredPersonDTO.getPremium());
              return insuredPerson;
            })
        .collect(Collectors.toList());
  }
}
