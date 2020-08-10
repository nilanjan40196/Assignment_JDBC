package com.bank.beans;

public class Account {
	private String accountId;
	private String accountName;
	private String addres;
	private double depositAmount;
	
	
	public void shpowDetails() {
		System.out.println("Account Name :"+getAccountName());
		System.out.println("Account Id : "+getAccountId());
		System.out.println("Address : "+getAddres());
		System.out.println("Deposit Amount is :"+getDepositAmount());
	}
	
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", address =" + addres+
				 ", depositAmount=" + depositAmount + "]";
	}

	public String getAccountId() {
		return accountId;
	}
	public Account() {
		super();
	}
	public Account(String accountId, String accountName, String addres, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.addres = addres;
		this.depositAmount = depositAmount;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
}
