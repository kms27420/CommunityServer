package com.kms.communityserver.dao;

import org.springframework.stereotype.Repository;

import com.kms.communityserver.model.account.AccountTO;

@Repository(value="accountMapper")
public interface AccountDAO {
	public boolean isAccountValid(AccountTO param);
}
