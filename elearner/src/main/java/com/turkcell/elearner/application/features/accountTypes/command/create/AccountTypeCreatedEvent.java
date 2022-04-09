package com.turkcell.elearner.application.features.accountTypes.command.create;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent {

	private String accountTypeId;

	private String accountName;

	private double price;

	private String description;
}
