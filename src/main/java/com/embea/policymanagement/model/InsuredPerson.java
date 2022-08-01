package com.embea.policymanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "insured_person")
public class InsuredPerson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @NotEmpty
  @Column(name = "first_name")
  private String firstName;

  @NotEmpty
  @Column(name = "second_name")
  private String secondName;

  @NotNull
  @Column(name = "premium")
  private BigDecimal premium;
}
