package com.turanulus.policymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PolicyManipulationReqBody {
  @NotNull
  @JsonProperty("policyId")
  private Long policyId;

  @Size(message = "Effective date cannot be bigger than 10")
  @NotEmpty(message = "Effective date cannot be empty")
  @JsonProperty("effectiveDate")
  private String effectiveDate;

  @Valid
  @NotEmpty
  @JsonProperty("insuredPersons")
  private List<InsuredPersonDTO> insuredPersonList;
}
