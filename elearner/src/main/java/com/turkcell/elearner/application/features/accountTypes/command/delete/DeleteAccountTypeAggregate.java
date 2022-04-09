package com.turkcell.elearner.application.features.accountTypes.command.delete;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class DeleteAccountTypeAggregate {

	@TargetAggregateIdentifier
	private String accountTypeId;

	public DeleteAccountTypeAggregate() {

	}

	@CommandHandler
	public DeleteAccountTypeAggregate(DeleteAccountTypeCommand deleteAccountTypeCommand) {

		AccountTypeDeletedEvent accountTypeDeletedEvent = new AccountTypeDeletedEvent();

		BeanUtils.copyProperties(deleteAccountTypeCommand, accountTypeDeletedEvent);
		AggregateLifecycle.apply(accountTypeDeletedEvent);

	}

	@EventSourcingHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		this.accountTypeId = accountTypeDeletedEvent.getAccountTypeId();

	}

}
