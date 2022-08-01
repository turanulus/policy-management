package com.turanulus.policymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PolicyInformationReqBody {
  @NotNull
  @JsonProperty("policyId")
  private Long policyId;

  @Size(message = "Request date cannot be bigger than 10")
  @NotEmpty(message = "Request date cannot be empty")
  @JsonProperty("requestDate")
  private String requestDate;
}
