package com.turkcell.elearner.application.features.accountTypes.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTypeUpdatedEvent {	
	
	private String accountTypeId;
	
	private String accountName;

	private double price;

	private String description;
	

}
