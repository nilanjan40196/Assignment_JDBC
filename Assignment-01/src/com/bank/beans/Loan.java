package com.bank.beans;

public class Loan extends Account{
	
	private int loanId;
	private int loanAmount;
	private LoanType loanType;
	
	
	//getLoan()
	
	
	public void showLoanDetails() {
		System.out.println("Loan Id = "+getLoanId());
		System.out.println("Loan amount = "+getLoanAmount());
		System.out.println("Loan Type = "+getLoanType());
	}
	
	
//	@Override
//	public String toString() {
//		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanType=" + loanType + "]";
//	}


	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}
	
	

}
