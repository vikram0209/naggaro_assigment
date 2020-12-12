package com.account.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.account.constant.AccountConstants;
import com.account.dao.AccountDao;
import com.account.dao.StatementDao;
import com.account.model.Account;
import com.account.model.AccountStatementRequest;
import com.account.model.Statement;
import com.account.service.AccountService;

@Service
public class StatementServiceImpl implements AccountService {

	LocalDate fromDate=null;
	LocalDate toDate=null;
	
	@Autowired
	StatementDao statementDao;
	
	@Autowired
	AccountDao accountDao;
	
	
	
	
	@Override
	public  ResultDto getStatement(AccountStatementRequest request,String userName) {
		ResultDto dto =new ResultDto();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
		    fromDate = LocalDate.now(); 
		    toDate=fromDate.plusMonths(3);
		/*if(userName.equals("testuser")){
			    toDate = LocalDate.now(); 
			    fromDate=fromDate.minusMonths(3);
		}else if(null!=request.getFromDate() && null!=request.getToDate() && userName.equals(AccountConstants.ADMIN_USER)){
			    fromDate = LocalDate.parse(request.getFromDate(),dtf);
			    toDate=LocalDate.parse(request.getToDate(),dtf);
		}else if (null==request.getFromDate()){
			toDate = LocalDate.now(); 
		    fromDate=fromDate.minusMonths(3);
		}*/
		
		List<Account> accountInfo=accountDao.getAccount(1);
		List<Statement> stmt=statementDao.getStatement(1);
		 List<Statement> finalList = stmt.stream().filter(l->(LocalDate.parse(l.getDatefield(),dtf).equals(fromDate)|| LocalDate.parse(l.getDatefield(),dtf).equals(toDate))|| LocalDate.parse(l.getDatefield(),dtf).isAfter(fromDate) && LocalDate.parse(l.getDatefield(),dtf).isBefore(toDate)).collect(Collectors.toList());
	 		
		//testing 
		dto.setAccountId(1);
		dto.setAccountNumber(accountInfo.get(0).getAccountNumber());
		dto.setAccountType(accountInfo.get(0).getAccountType());
		/*Statement stmt1=new Statement();
		stmt1.setID(1);
		stmt1.setDatefield("12.01.2020");
		stmt1.setAmount("10");
		Statement stmt2=new Statement();
		stmt2.setID(1);
		stmt2.setDatefield("07.01.2020");
		stmt2.setAmount("20");
		Statement stmt3=new Statement();
		stmt3.setID(1);
		stmt3.setDatefield("18.01.2020");
		stmt3.setAmount("10");
		finalList.add(stmt1);
		finalList.add(stmt2);
		finalList.add(stmt3);*/
		Collections.sort(finalList);
		dto.setStmtList(finalList);
		return  dto;
	}

	

	

}