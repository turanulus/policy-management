package com.turanulus.policymanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "policy")
public class Policy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @NotNull
  @Column(name = "start_date")
  private Date startDate;

  @NotEmpty
  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
  private List<InsuredPerson> insuredPersonList;
}
