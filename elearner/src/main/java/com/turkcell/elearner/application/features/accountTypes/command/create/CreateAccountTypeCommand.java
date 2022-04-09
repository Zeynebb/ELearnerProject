package com.turkcell.elearner.application.features.accountTypes.command.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountTypeCommand {

	@TargetAggregateIdentifier
	private String accountTypeId;
	
	private final String accountName;

	private final double price;

	private final String description;

}
