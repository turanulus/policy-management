package com.turanulus.policymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PolicyCreationReqBody {
  @Size(message = "Start date cannot be bigger than 10")
  @NotEmpty(message = "Start date cannot be empty")
  @JsonProperty("startDate")
  private String startDate;

  @Valid
  @NotEmpty
  @JsonProperty("insuredPersons")
  private List<InsuredPersonDTO> insuredPersonList;
}
