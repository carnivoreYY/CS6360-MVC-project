package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.BorrowerDAO;
import com.luv2code.springdemo.entity.Borrower;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	
	@Autowired
	private BorrowerDAO borrowerDAO;
	
	
	@Override
	@Transactional
	public List<Borrower> getBorrowers() {

		return borrowerDAO.getBorrowers();
	}

	@Override
	@Transactional
	public void saveBorrower(Borrower theBorrower) {

		borrowerDAO.saveBorrower(theBorrower);
	}


}
