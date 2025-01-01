package com.bank.loan.repository;

import com.bank.loan.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards,Long> {
    public Optional<Cards> findByMobileNumber(String mobileNumber);
    public Optional<Cards> findByCardNumber(String cardNumber);
}
