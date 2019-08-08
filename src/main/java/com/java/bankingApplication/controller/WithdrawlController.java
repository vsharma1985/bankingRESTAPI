package com.java.bankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bankingApplication.service.TransactionService;


@RestController
@RequestMapping(path = "/withdraw")
public class WithdrawlController {

	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value ="/{accountNumber}/{amount}",method=RequestMethod.POST)
	public void withdrawAmount(@PathVariable("accountNumber") Integer accountNumber,@PathVariable("amount") Integer amount) {
		
		System.out.println("Depositing the Amount ***"+amount +" to "+accountNumber);
		
		transactionService.withdrawAmount(accountNumber,amount);
	}
}
