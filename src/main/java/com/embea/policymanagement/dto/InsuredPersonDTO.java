package com.embea.policymanagement.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
public class InsuredPersonDTO {
  @NotEmpty(message = "First name cannot be empty")
  @Size(max = 80, message = "First name length cannot be bigger than 80")
  @Column(name = "first_name")
  private String firstName;

  @NotEmpty(message = "Second name cannot be empty")
  @Size(max = 80, message = "Second name length cannot be bigger than 80")
  @Column(name = "second_name")
  private String secondName;

  @NotNull
  @Column(name = "premium")
  private BigDecimal premium;
}
