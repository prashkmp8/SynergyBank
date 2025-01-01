package com.bank.loan.service;

import com.bank.loan.dto.AccountsDto;
import com.bank.loan.dto.CustomerDto;
import com.bank.loan.dto.ResponseDto;
import com.bank.loan.entity.Customer;
import com.bank.loan.exception.CustomerAlreadyExistsException;
import com.bank.loan.exception.ResourseNotFoundException;
import com.bank.loan.mapper.AccountsMapper;
import com.bank.loan.mapper.CustomerMapper;
import com.bank.loan.repository.AccountsRepository;
import com.bank.loan.repository.CustomerRepository;
import com.bank.loan.entity.Accounts;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsService {
    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    public void createAccount(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists in the Database - " + customerDto.getName());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        customerRepository.save(customer);

        Accounts accounts = createNewAccount(customer.getCustomerId());
        accountsRepository.save(accounts);
    }


    private Accounts createNewAccount(Long customerId) {
        Accounts accounts = new Accounts();
        Long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType("SAVINGS");
        accounts.setCustomerId(customerId);
        accounts.setBranchAddress("201 Main Road, Wakad, Pune");
        return accounts;
    }


    public CustomerDto fetchCustomer(String mobileNumber) {
        Customer foundCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourseNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        CustomerDto customerDto = CustomerMapper
                .mapToCustomerDto(foundCustomer, new CustomerDto());

        Accounts accounts = accountsRepository.findByCustomerId(foundCustomer.getCustomerId()).orElseThrow(
                () -> new ResourseNotFoundException("Accounts", "customer id", foundCustomer.getCustomerId().toString())
        );
        AccountsDto accountsDto = AccountsMapper.mapToAccountsDto(accounts, new AccountsDto());
        customerDto.setAccountsDto(accountsDto);
        return customerDto;
    }

    public ResponseDto deleteAccount(String mobileNumber) {
        Customer foundCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourseNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(foundCustomer.getCustomerId()).orElseThrow(
                () -> new ResourseNotFoundException("Accounts", "customer id", foundCustomer.getCustomerId().toString())
        );
        accountsRepository.delete(accounts);
        customerRepository.delete(foundCustomer);
        ResponseDto dto=new ResponseDto();
        dto.setMessage("account has been deleted successfully.");
        dto.setStatusCode(HttpStatus.ACCEPTED);
        return dto;
    }

    public void updateAccount(String mobileNumber, CustomerDto customerDto) {
        Customer foundCustomer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourseNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Customer updatedCustomer = CustomerMapper.mapToCustomer(customerDto, foundCustomer);

        Accounts accounts = accountsRepository.findByCustomerId(foundCustomer.getCustomerId()).orElseThrow(
                () -> new ResourseNotFoundException("Accounts", "customer id", foundCustomer.getCustomerId().toString())
        );

        Accounts updatedAccount = AccountsMapper.mapToAccounts(customerDto.getAccountsDto(), accounts);

        customerRepository.save(updatedCustomer);
        accountsRepository.save(updatedAccount);
    }
}
