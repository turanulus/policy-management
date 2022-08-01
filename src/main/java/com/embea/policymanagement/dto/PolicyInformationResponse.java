package com.embea.policymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PolicyInformationResponse {
  @JsonProperty("policyId")
  private Long policyId;

  @JsonProperty("requestDate")
  private String requestDate;

  @JsonProperty("insuredPersons")
  private List<InsuredPersonDTO> insuredPersonList;

  @JsonProperty("totalPremium")
  private Float totalPremium;
}
