package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Borrower;

public interface BorrowerService {

	List<Borrower> getBorrowers();

	void saveBorrower(Borrower theBorrower);


}
