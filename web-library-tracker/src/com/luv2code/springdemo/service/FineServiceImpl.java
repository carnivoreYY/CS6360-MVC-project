package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.FinesDAO;

@Service
public class FineServiceImpl implements FinesService {
	
	@Autowired
	private FinesDAO finesDAO;

	@Override
	@Transactional
	public void saveFines() {
		
		finesDAO.saveFines();
	}

}
