package com.turkcell.elearner.application.features.accountTypes.command.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;

@Component("createAccountTypeEventHandler")
public class AccountTypeEventsHandler {

	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	@EventHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		//business codes
		//add repository...- checkIf, add, delete gibi 

		AccountType accountType = new AccountType();

		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		
		this.accountTypeRepository.save(accountType);

	}

}
