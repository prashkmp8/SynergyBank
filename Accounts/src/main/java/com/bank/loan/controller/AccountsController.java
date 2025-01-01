package com.bank.loan.controller;

import com.bank.loan.dto.ResponseDto;
import com.bank.loan.dto.CustomerDto;
import com.bank.loan.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/accounts")
@AllArgsConstructor
@Tag(name="Accounts related functionalities which perform crud operation")

public class AccountsController {

    private AccountsService accountsService;

    @PostMapping
    @Operation(description = "create Account Method")
    @ApiResponses(
            @ApiResponse(responseCode = "201", description = "Creating new account")
    )
    public ResponseEntity<ResponseDto> createAccounts(@RequestBody CustomerDto customerDto){
        accountsService.createAccount(customerDto);
        ResponseDto dto = new ResponseDto();
        dto.setStatusCode(HttpStatus.CREATED);
        dto.setMessage("account has been created successfully.");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }

    @GetMapping(value = "/{mobileNumber}")
    @Operation(description = "Getting matched Accounts")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "getting all accounts which has matched mobile number")
    )
    public ResponseEntity<CustomerDto> getAccounts(@PathVariable("mobileNumber") String mobileNumber){
        CustomerDto customerDto= accountsService.fetchCustomer(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDto);
    }

    @DeleteMapping(value = "/{mobileNumber}")
    @Operation(description = "Deleting Account")
    @ApiResponses(
            @ApiResponse(responseCode = "202", description = "deleting account which has matched mobile number")
    )
    public ResponseEntity<ResponseDto> deleteAccounts(@PathVariable("mobileNumber") String mobileNumber){
        ResponseDto responseDto =accountsService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(responseDto);
    }

}
