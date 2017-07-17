package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Payment;

public interface PaymentService {

	List<Payment> getPayments();

	void savePayments(int theId);

}
