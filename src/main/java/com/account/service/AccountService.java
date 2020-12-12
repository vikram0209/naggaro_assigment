package com.account.service;

import java.util.List;

import com.account.model.AccountStatementRequest;
import com.account.model.Statement;
import com.account.service.impl.ResultDto;

public interface AccountService {
	
	ResultDto getStatement(AccountStatementRequest request ,String userNames);

}