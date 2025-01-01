package com.bank.loan.repository;

import com.bank.loan.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

}
