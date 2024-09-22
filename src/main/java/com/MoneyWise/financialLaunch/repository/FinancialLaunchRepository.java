package com.MoneyWise.financialLaunch.repository;

import com.MoneyWise.financialLaunch.entity.FinancialLaunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinancialLaunchRepository extends JpaRepository<FinancialLaunch, UUID> {
}
