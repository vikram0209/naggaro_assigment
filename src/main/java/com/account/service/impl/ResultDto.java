package com.account.service.impl;

import java.util.List;

import com.account.model.Statement;

public class ResultDto {
	
	private List<Statement> stmtList;
	private int accountId;
	private Long accountNumber;
	private String accountType;
	
	
	public ResultDto(){}

	public ResultDto(List<Statement> stmtList, int accountId,
			Long accountNumber, String accountType) {
		super();
		this.stmtList = stmtList;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Statement> getStmtList() {
		return stmtList;
	}

	public void setStmtList(List<Statement> stmtList) {
		this.stmtList = stmtList;
	}

}
