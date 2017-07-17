package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Borrower;

public interface BorrowerDAO {

	public List<Borrower> getBorrowers();

	public void saveBorrower(Borrower theBorrower);

}
