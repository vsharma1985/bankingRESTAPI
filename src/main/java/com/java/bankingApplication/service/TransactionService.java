package com.java.bankingApplication.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bankingApplication.entity.Account;
import com.java.bankingApplication.exception.BankingAppException;
import com.java.bankingApplication.repo.AccountRepo;

@Service
public class TransactionService {
	
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepo accountRepo;
	
@Transactional
public synchronized void depositAmount(Integer accountNumber, Integer amount) {
		
		Account account  = accountService.getAccountDetails(accountNumber);
		int depositedamount = account.getAccountBalance()+amount;
		account.setAccountBalance(depositedamount);
		
		accountRepo.save(account);
		
	}

@Transactional
	public synchronized void withdrawAmount(Integer accountNumber, Integer amount) {
		Account account  = accountService.getAccountDetails(accountNumber);
		
		if(amount>account.getAccountBalance()) {
			throw new BankingAppException("Withdrwal Amount is greater than balance Available");
		}
		
		int withdrwalAmount = account.getAccountBalance()-amount;
		account.setAccountBalance(withdrwalAmount);
		
		accountRepo.save(account);
		
	}
	@Transactional
	public synchronized void fundTransfer(Integer sourceAccNumber, Integer destAccNumberInteger ,Integer amount) {
		
		if(null ==sourceAccNumber || null == destAccNumberInteger  ) {
			
			throw new BankingAppException("Enter the Valid account Number to initiate the transfer of funds");

		}
		
		else {
			Account sourceAccount  = accountService.getAccountDetails(sourceAccNumber);
			Account destAccount  = accountService.getAccountDetails(destAccNumberInteger);
			
			if(amount>sourceAccount.getAccountBalance()) {
				throw new BankingAppException("Insufficient funds , Enter the valid amount ");
			}
			
			int transferedAmount = destAccount.getAccountBalance()+amount;
			sourceAccount.setAccountBalance(sourceAccount.getAccountBalance()-amount);
			destAccount.setAccountBalance(transferedAmount);
			accountRepo.save(destAccount);
		}
	}
	
}
