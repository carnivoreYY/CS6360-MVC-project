package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.PaymentDAO;
import com.luv2code.springdemo.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;

	@Override
	@Transactional
	public List<Payment> getPayments() {

		return paymentDAO.getPayments();
	}

	@Override
	@Transactional
	public void savePayments(int theId) {

		paymentDAO.savePayments(theId);
	}
}
