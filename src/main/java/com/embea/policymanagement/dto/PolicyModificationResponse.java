package com.embea.policymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PolicyModificationResponse {
  @JsonProperty("policyId")
  private Long policyId;

  @JsonProperty("effectiveDate")
  private String effectiveDate;

  @JsonProperty("insuredPersons")
  private List<InsuredPersonDTO> insuredPersonList;

  @JsonProperty("totalPremium")
  private Float totalPremium;
}
