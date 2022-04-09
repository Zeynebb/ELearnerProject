package com.turkcell.elearner.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.elearner.domain.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, String> {
	

}
