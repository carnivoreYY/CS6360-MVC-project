package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Loan;

public interface LoanService {

	public List<Loan> getLoans();

	public void saveLoans(Loan theLoan);

	public Loan getLoans(long theId);

	public void saveLoan(Loan theLoan);

	public List<Loan> getLoan();

	public List<Loan> updateLoan(int theId);

}
