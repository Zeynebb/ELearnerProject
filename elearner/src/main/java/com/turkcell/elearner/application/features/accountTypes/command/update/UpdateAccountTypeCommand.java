package com.turkcell.elearner.application.features.accountTypes.command.update;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAccountTypeCommand {
	
	@TargetAggregateIdentifier
	private String accountTypeId;
	
	private String accountName;

	private double price;

	private String description;

}
