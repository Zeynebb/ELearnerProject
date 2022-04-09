package com.turkcell.elearner.application.features.accountTypes.command.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTypeDeletedEvent {	

	private String accountTypeId;

}
