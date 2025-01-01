package com.bank.loan.constant;

import org.springframework.http.HttpStatus;

public class LoansConstants {


    public static final String  HOME_LOAN = "Home Loan";
    public static final int  NEW_LOAN_LIMIT = 1_00_000;
    public static final HttpStatus STATUS_201 = HttpStatus.CREATED;
    public static final String  MESSAGE_201 = "Loan created successfully";
    public static final HttpStatus  STATUS_200 = HttpStatus.ACCEPTED;
    public static final String  MESSAGE_200 = "Request processed successfully";
    public static final HttpStatus  STATUS_417 = HttpStatus.EXPECTATION_FAILED;
    public static final String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
    public static final String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";
    // public static final String  STATUS_500 = "500";
    // public static final String  MESSAGE_500 = "An error occurred. Please try again or contact Dev team";

}
