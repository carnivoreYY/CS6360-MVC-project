package com.luv2code.springdemo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {

	@Id
	@Column(name="Card_id")
	private int card_no;
	
	@Column(name="Amount")
	private BigDecimal amount;
	
	public Payment() {}

	public int getCard_no() {
		return card_no;
	}

	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [card_no=" + card_no + ", amount=" + amount + "]";
	}
	
	
}
