package com.embea.policymanagement.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
  private String message;
}
