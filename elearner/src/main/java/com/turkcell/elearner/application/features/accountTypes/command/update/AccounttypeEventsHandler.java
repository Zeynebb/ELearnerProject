package com.turkcell.elearner.application.features.accountTypes.command.update;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;

@Component("updateAccountTypeEventHandler")
public class AccounttypeEventsHandler {

	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public AccounttypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	@EventHandler
	public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {

		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeUpdatedEvent, accountType);
		this.accountTypeRepository.save(accountType);

	}

}
