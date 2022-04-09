package com.turkcell.elearner.application.features.accountTypes.command.delete;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteAccountTypeCommand {
	
	@TargetAggregateIdentifier
	private String accountTypeId;

}
