package com.account.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {
    private int ID;
	private String accountType;
	private Long accountNumber;

	
	
	public Account(int ID,String accountType,Long accountNumber ){
		this.ID=ID;
		this.accountType=accountType;
		this.accountNumber=accountNumber;
		
		
		
	}
	

	public int getID() {
		return ID;
	}






	public void setID(int iD) {
		ID = iD;
	}






	public String getAccountType() {
		return accountType;
	}






	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}






	public Long getAccountNumber() {
		return accountNumber;
	}






	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}






	public Account(){
		
		
	}

	

}