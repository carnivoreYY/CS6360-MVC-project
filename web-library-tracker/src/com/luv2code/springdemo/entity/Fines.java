package com.luv2code.springdemo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fines")
public class Fines {

	@Id
	@Column(name="Loan_id")
	private int loan_id;
	
	@Column(name="Fine_amt")
	private BigDecimal fine_amt;
	
	@Column(name="Paid")
	private int paid;
	
	public Fines() {}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public BigDecimal getFine_amt() {
		return fine_amt;
	}

	public void setFine_amt(BigDecimal fine_amt) {
		this.fine_amt = fine_amt;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Fines [loan_id=" + loan_id + ", fine_amt=" + fine_amt + ", paid=" + paid + "]";
	}
	
	
}
