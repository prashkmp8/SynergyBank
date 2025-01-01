package com.bank.loan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cards")
@Data
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private Long totalLimit;
    private Long usedAmount;
    private Long availableAmount;

    public Cards() {
    }

    public Cards(Long cordId, String mobileNumber, String cardNumber, String cardType, Long totalLimit, Long usedAmount, Long availableAmount) {
        this.cardId = cordId;
        this.mobileNumber = mobileNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.usedAmount = usedAmount;
        this.availableAmount = availableAmount;
    }

    public Long getCordId() {
        return cardId;
    }

    public void setCordId(Long cordId) {
        this.cardId = cordId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(Long totalLimit) {
        this.totalLimit = totalLimit;
    }

    public Long getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Long usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Long getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Long availableAmount) {
        this.availableAmount = availableAmount;
    }
}
