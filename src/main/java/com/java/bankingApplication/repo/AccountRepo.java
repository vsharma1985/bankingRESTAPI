package com.java.bankingApplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.bankingApplication.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

	Optional<Account> findByAccountNumber(Integer accountNumber);
	

}
