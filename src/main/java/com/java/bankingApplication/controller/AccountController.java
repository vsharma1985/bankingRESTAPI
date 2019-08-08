package com.java.bankingApplication.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bankingApplication.entity.Account;
import com.java.bankingApplication.service.AccountService;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
	
	 static final Logger LOGGER = Logger.getLogger(AccountController.class);


	@Autowired
	private AccountService accountService	;
	
	@RequestMapping(value ="/",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to Banking App";
	}
	
	
	@RequestMapping(value ="/{id}",method=RequestMethod.GET)
	public Account getAccountDetails(@PathVariable("id") Integer accountNumber) {
		
		return accountService.getAccountDetails(accountNumber);
	}
	
	@RequestMapping(value ="/",method=RequestMethod.POST)
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id") Integer id) {
         accountService.deleteAccount(id);
    }
	
	
}
