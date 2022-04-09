package com.turkcell.elearner.application.features.accountTypes.command.delete;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;

@Component("deleteAccountTypeEventHandler")
public class AccountTypeEventsHandler {
	
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		
		AccountType accountType = new AccountType();
		
		BeanUtils.copyProperties(accountTypeDeletedEvent, accountType);
		this.accountTypeRepository.delete(accountType);
		
	}
	

}
