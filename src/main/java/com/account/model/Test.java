package com.account.model;



import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
 
/**
 * This program demonstrates how to use UCanAccess JDBC driver to read/write
 * a Microsoft Access database.
 * @author www.codejava.net
 *
 */
public class Test {
 
    public static void main(String[] args) {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
    	 LocalDate fromDate = LocalDate.parse("01.05.2012",dtf); 
    	 LocalDate  toDate= fromDate.parse("15.05.2012",dtf);
    	
    	
    	List<Statement> stm1=new ArrayList<Statement>();
    	 Statement a=new Statement(1,"12.05.2012","111");
    	 Statement b=new Statement(1,"01.05.2012","111");
    	 Statement c=new Statement(1,"07.05.2012","111");
    	 Statement d=new Statement(1,"15.05.2012","111");
    	 stm1.add(a);
    	 stm1.add(b);
    	 stm1.add(c);
    	 stm1.add(d);
    	 List<Statement> finalList = stm1.stream().filter(l->(LocalDate.parse(l.getDatefield(),dtf).equals(fromDate)|| LocalDate.parse(l.getDatefield(),dtf).equals(toDate))|| LocalDate.parse(l.getDatefield(),dtf).isAfter(fromDate) && LocalDate.parse(l.getDatefield(),dtf).isBefore(toDate)).collect(Collectors.toList());
 		Collections.sort(finalList);
 		
    	 System.out.print(finalList);
 		
    	
    	
    	
    	
    }
}