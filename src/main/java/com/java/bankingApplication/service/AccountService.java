package com.java.bankingApplication.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bankingApplication.controller.AccountController;
import com.java.bankingApplication.entity.Account;
import com.java.bankingApplication.exception.BankingAppException;
import com.java.bankingApplication.repo.AccountRepo;

@Service
public class AccountService{

	@Autowired
	AccountRepo accountRepo;
	 static final Logger LOGGER = Logger.getLogger(AccountController.class);

	public void createAccount(Account account) {
		LOGGER.info("Creating the New Account ");
		
		if(null==account) {
			throw new BankingAppException("Enter the Mandatory Account details ... ");
		}
		accountRepo.save(account);
		
	}

	
	public Account getAccountDetails(Integer accountNumber) {
		
		Optional<Account> account = accountRepo.findByAccountNumber(accountNumber);
		
		if(account.isPresent()) {
			LOGGER.info("Getting  Account Details ...");
            return account.get();
        } else {
            throw new BankingAppException("No Account exist for given Account Number");
        }
		
	}

	
	public void deleteAccount(Integer id) {
		Optional<Account> account = accountRepo.findById(id);
		
		if(account.isPresent())
        {
			LOGGER.info("Deleting  Account ... ");
			accountRepo.deleteById(id);
        } else {
            throw new BankingAppException("No Account exist for given Account Number");
        }
		
		accountRepo.deleteById(id);
		
	}


	

}
