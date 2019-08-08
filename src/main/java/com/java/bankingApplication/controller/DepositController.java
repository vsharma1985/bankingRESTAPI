package com.java.bankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bankingApplication.service.TransactionService;


@RestController
@RequestMapping(path = "/deposit")
public class DepositController {

	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value ="/{accountNumber}/{amount}",method=RequestMethod.POST)
	public void depositAmount(@PathVariable("accountNumber") Integer accountNumber,@PathVariable("amount") Integer amount) {
		
		System.out.println("Depositing the Amount ***"+amount +" to "+accountNumber);
		
		transactionService.depositAmount(accountNumber,amount);
	}
	
	@RequestMapping(value ="/{sourceAccNumber}/{amount}/{destAccNumber}",method=RequestMethod.POST)
	public void transferFunds(@PathVariable("sourceAccNumber") Integer sourceAccNumber,@PathVariable("amount") Integer amount,@PathVariable("destAccNumber") Integer destAccNumber){ {
		
		System.out.println("Intitaiting Transfering of Funds ***");
		
		transactionService.fundTransfer(sourceAccNumber, destAccNumber, amount);
	}
	
	}}
