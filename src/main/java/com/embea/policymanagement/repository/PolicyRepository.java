package com.embea.policymanagement.repository;

import com.embea.policymanagement.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {}
