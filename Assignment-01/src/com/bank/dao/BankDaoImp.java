package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.beans.Account;
import com.bank.beans.Loan;
import com.bank.beans.LoanType;
import com.bank.beans.Transaction;

public class BankDaoImp implements BankDao {
	
	//Transaction[] accounts = new Transaction[10];
	//private static int i = 0;
	int amount = 0;
	
	String url="jdbc:mysql://localhost:3306/capgemini";
	String uname="root",password="mySql@12345";
	
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url,uname,password);
	//Statement st = conn.createStatement();
	
	public BankDaoImp() throws Exception {
		/*
		 * String url="jdbc:mysql://localhost:3306/capgemini"; String
		 * uname="root",password="mySql@12345";
		 * 
		 * Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * System.out.println("connecting database "); Connection conn =
		 * DriverManager.getConnection(url,uname,password);
		 * System.out.println("database connected ");
		 */
		
		
		
//		String sql = "create table Account_01"+
//						"(accountId varchar(11) primary key,"+
//						"accountName varchar(15) not null, "+
//						"address varchar(30), "+
//						"depositAmount double not null," +
//						"loanID mediumint, "+
//						"loanAmount int ,"+
//						"loanType varchar(20))";
//		
//		st.executeUpdate(sql);
//		System.out.println(" table created");
		
	}
	
	

	@Override
	public int depositAmount(String accId, int amt) throws SQLException {
		
//		for(Account acc : accounts) {
//			if(acc.getAccountId().equals(accId)) {
//				amount = acc.getDepositAmount()+amt;
//				acc.setDepositAmount(acc.getDepositAmount()+amt);
//				System.out.println("Deposit succesful");
//				break;
//			}
//		}
		
		//JDBC
		
		//Statement st = conn.createStatement();
		String getAmount = "select depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAmount);
		
		pst.setString(1, accId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		int amount1 = rs.getInt(1)+amt;
		
		String depoUpdate = "update account_01 set depositAmount = ? where accountId = ?";
		PreparedStatement pst1 = conn.prepareStatement(depoUpdate);
		pst1.setInt(1, amount1);
		pst1.setString(2, accId);
		pst1.executeUpdate();
		
		//System.out.println("fetch res = "+amount1);
		return amount1;
	}

	@Override
	public int withdrawAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
//		for(Account ac : accounts) {
//			if(ac.getAccountId().equals(accId)) {
//				amount = ac.getDepositAmount()-amt;
//				ac.setDepositAmount(ac.getDepositAmount()+amt);
//				System.out.println("Withdraw succesful");
//				break;
//			}
//		}
		
		//jDBc
		
		String getAmount = "select depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAmount);
		
		pst.setString(1, accId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		int amount1 = rs.getInt(1)-amt;
		
		String depoUpdate = "update account_01 set depositAmount = ? where accountId = ?";
		PreparedStatement pst1 = conn.prepareStatement(depoUpdate);
		pst1.setInt(1, amount1);
		pst1.setString(2, accId);
		pst1.executeUpdate();
		
		
		
		return amount1;
	}

	@Override
	public Account showAccountDetails(String accountNo) throws SQLException {
//		for(Account acc : accounts) {
//			if(acc.getAccountId().equals(accountNo)) {
//				return acc;
//			}
//		}
		
		String getAccDetails = "select accountId,accountName,address,depositAmount from account_01 where accountId = ?";
		PreparedStatement pst = conn.prepareStatement(getAccDetails);
		pst.setString(1, accountNo);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Account acc =new Account();
		acc.setAccountId(rs.getString(1));
		acc.setAccountName(rs.getString(2));
		acc.setAddres(rs.getString(3));
		acc.setDepositAmount(rs.getDouble(4));
		
		return acc;
	}

	@Override
	public void createAccount(Account account) throws SQLException {
//		if(i<9)
//			accounts[i++]=(Transaction) account;					// using array
//		else
//			System.out.println("Array size full");
		
		
		
		Transaction t = (Transaction) account;
		String insertSql = "insert into Account_01 "+
							"(accountId,accountName,address,depositAmount,loanID,loanAmount,loanType)"+"values(?,?,?,?,?,?,?)";
																																				/*+ t.getAccountId()+","+t.getAccountName()+","+t.getAddres()+","+t.getDepositAmount()+","+t.getLoanId()+","+t.getLoanAmount()+","+t.getLoanType()+")";*/
		
		
		PreparedStatement pst = conn.prepareStatement(insertSql);
		
		pst.setString(1, t.getAccountId());
		pst.setString(2, t.getAccountName());
		pst.setString(3, t.getAddres());
		pst.setDouble(4, t.getDepositAmount());
		pst.setInt(5, t.getLoanId());
		pst.setInt(6, t.getLoanAmount());
		pst.setString(7, String.valueOf(t.getLoanType()));
		
		
		int c = pst.executeUpdate();
		System.out.println(c+" rows affected ");
	}

	@Override
	public int getLoan(int loanId, int lamt) throws SQLException {
		// TODO Auto-generated method stub
		int loanBal = 0;
//		for(Loan l : accounts) {
//			if(l.getLoanId()==loanId) {
//				loanBal = l.getLoanAmount()+lamt;
//				l.setLoanAmount(loanBal);
//			}
//		}
		
		//JDBC
		String getLoan = "select loanAmount from account_01 where loanID = ?";
		PreparedStatement pst = conn.prepareStatement(getLoan);
		pst.setInt(1, loanId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		loanBal = rs.getInt(1);
		loanBal += lamt;
		
		String updateLoan = "update account_01 set loanAmount = ? where loanID = ?";
		PreparedStatement pst1 = conn.prepareStatement(updateLoan);
		pst1.setInt(1, loanBal);
		pst1.setInt(2, loanId);
		pst1.executeUpdate();
		
		return loanBal;
	}

	@Override
	public Loan showLoanDetails(int loanId) throws SQLException {
//		for(Loan l : accounts) {
//			if(l.getLoanId()==loanId) {
//				return l;
//			}
//		}return null;
		
		//JDBC
		
		PreparedStatement pst = conn.prepareStatement("select loanID,loanAmount,loanType from account_01 where loanID = ?");
		pst.setInt(1, loanId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Loan l = new Loan();
		l.setLoanId(rs.getInt(1));
		l.setLoanAmount(rs.getInt(2));
		l.setLoanType(LoanType.valueOf(rs.getString(3)));
		
		return l;
				
	}

	@Override
	public int payLoan(int loanId, int lamt) throws SQLException {
		int loanBal = 0;
//		for(Loan l : accounts) {
//			if(l.getLoanId()==loanId) {
//				loanBal = l.getLoanAmount()-lamt;
//				l.setLoanAmount(loanBal);
//			}
//		}
		
		//JDBC
		
		String getLoan = "select loanAmount from account_01 where loanID = ?";
		PreparedStatement pst = conn.prepareStatement(getLoan);
		pst.setInt(1, loanId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		loanBal = rs.getInt(1);
		loanBal -= lamt;
		
		String updateLoan = "update account_01 set loanAmount = ? where loanID = ?";
		PreparedStatement pst1 = conn.prepareStatement(updateLoan);
		pst1.setInt(1, loanBal);
		pst1.setInt(2, loanId);
		pst1.executeUpdate();
		
		return loanBal;
		
	}

}
