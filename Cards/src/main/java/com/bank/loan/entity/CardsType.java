package com.bank.loan.entity;

public enum CardsType {
    DEBIT("debit"),CREDIT("credit");
    String name;

    CardsType(String name) {
        this.name = name;
    }
}
