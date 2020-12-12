package com.account.dao;

import java.util.List;

import com.account.model.Account;
import com.account.model.Statement;

public interface AccountDao {
	List<Account> getAccount(int accountId);
}