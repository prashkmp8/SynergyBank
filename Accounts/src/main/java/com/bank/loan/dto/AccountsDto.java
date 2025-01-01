package com.bank.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(
        description = "Account details",
        name = "AccountDto"
)
public class AccountsDto {
    @Schema(
            name = "mobile Number"
    )
    private Long accountNumber;
    @Schema(
            name = "customer id"
    )
    private Long customerId;
    @Schema(
            name = "Account Type"
    )
    private String accountType;
    @Schema(
            name = "Branch Address"
    )
    private String branchAddress;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
