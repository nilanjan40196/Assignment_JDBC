package com.bank.service;

import java.sql.SQLException;

import com.bank.beans.Account;
import com.bank.beans.Loan;

public interface BankService {
	
	public boolean validateAccountId(String id);
	public boolean validateAccountName(String name);
	
	public int depositAmount(String accId,int amt) throws SQLException;
	public int withdrawAmount(String accId,int amt) throws SQLException;
	public Account showAccountDetails(String accountNo) throws SQLException;
	public void createAccount(Account account) throws SQLException;
	
	public int getLoan(int loanId,int lamt) throws SQLException;
	public int payLoan(int loanId,int lamt) throws SQLException;
	public Loan showLoanDetails(int loanId) throws SQLException;
}
