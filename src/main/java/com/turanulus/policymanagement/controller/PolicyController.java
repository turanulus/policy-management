package com.turanulus.policymanagement.controller;

import com.turanulus.policymanagement.dto.*;
import com.turanulus.policymanagement.service.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/policies")
public class PolicyController {

  private final PolicyService policyService;

  @PostMapping
  public ResponseEntity<PolicyCreationResponse> createPolicy(
      @Valid @RequestBody PolicyCreationReqBody policyBody) {
    PolicyCreationResponse response = policyService.create(policyBody);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/modification")
  public ResponseEntity<PolicyModificationResponse> updatePolicy(
      @Valid @RequestBody PolicyManipulationReqBody policyBody) {
    PolicyModificationResponse response = policyService.update(policyBody);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<PolicyInformationResponse> getPolicy(
      @Valid @RequestBody PolicyInformationReqBody policyBody) {
    PolicyInformationResponse response = policyService.getPolicy(policyBody);
    return ResponseEntity.ok(response);
  }
}
