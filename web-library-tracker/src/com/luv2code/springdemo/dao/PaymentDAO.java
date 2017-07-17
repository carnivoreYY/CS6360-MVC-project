package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Payment;

public interface PaymentDAO {

	List<Payment> getPayments();

	void savePayments(int theId);

}
