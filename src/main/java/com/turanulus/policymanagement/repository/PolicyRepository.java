package com.turanulus.policymanagement.repository;

import com.turanulus.policymanagement.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {}
