package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.LoanDAO;
import com.luv2code.springdemo.entity.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDAO loanDAO;

	@Override
	@Transactional
	public List<Loan> getLoans() {

		return loanDAO.getLoans();
	}

	@Override
	@Transactional
	public void saveLoans(Loan theLoan) {

		loanDAO.saveLoans(theLoan);
	}

	@Override
	@Transactional
	public Loan getLoans(long theId) {
		
		return loanDAO.getLoans(theId);
	}

	@Override
	@Transactional
	public void saveLoan(Loan theLoan) {

		loanDAO.saveLoan(theLoan);
	}

	@Override
	@Transactional
	public List<Loan> getLoan() {

		return loanDAO.getLoan();
	}

	@Override
	@Transactional
	public List<Loan> updateLoan(int theId) {
		
		return loanDAO.updateLoan(theId);
	}


}
