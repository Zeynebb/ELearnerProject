package com.turkcell.elearner.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.elearner.application.features.accountTypes.command.create.CreateAccountTypeCommand;
import com.turkcell.elearner.application.features.accountTypes.command.delete.DeleteAccountTypeCommand;
import com.turkcell.elearner.application.features.accountTypes.command.update.UpdateAccountTypeCommand;
import com.turkcell.elearner.ws.models.CreateAccountTypeModel;
import com.turkcell.elearner.ws.models.DeleteAccountTypeModel;
import com.turkcell.elearner.ws.models.UpdateAccountTypeModel;

@RestController
@RequestMapping("/accounttypes")
public class AccountTypesController {

	private CommandGateway commandGateway;

	@Autowired
	public AccountTypesController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/add")
	public void createAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel) {

		CreateAccountTypeCommand createAccountType = CreateAccountTypeCommand.builder()
				.price(createAccountTypeModel.getPrice()).accountName(createAccountTypeModel.getAccountName())
				.description(createAccountTypeModel.getDescription()).build();

		createAccountType.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(createAccountType);
	}

	@PutMapping("/update")
	public void updateAccountType(@RequestBody UpdateAccountTypeModel updateAccountTypeModel) {

		UpdateAccountTypeCommand updateAccountTypeCommand = UpdateAccountTypeCommand.builder()
				.accountTypeId(updateAccountTypeModel.getAccountTypeId())
				.accountName(updateAccountTypeModel.getAccountTypeId())
				.description(updateAccountTypeModel.getDescription()).price(updateAccountTypeModel.getPrice()).build();

		this.commandGateway.sendAndWait(updateAccountTypeCommand);
	}

	@DeleteMapping("/delete")
	public void deleteAccountType(@RequestBody DeleteAccountTypeModel deleteAccountTypeModel) {

		DeleteAccountTypeCommand deleteAccountTypeCommand = DeleteAccountTypeCommand.builder()
				.accountTypeId(deleteAccountTypeModel.getAccountTypeId()).build();

		this.commandGateway.sendAndWait(deleteAccountTypeCommand);

	}

}
