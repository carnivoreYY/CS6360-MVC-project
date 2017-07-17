package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Loan")
public class Loan {

	@Id	
	@Column(name="L_id")
	private int loan_id;
	
	@Column(name="I_no")
	private long isbn;
	
	@Column(name="C_id")
	private int card_id;
	
	@Column(name="Date_out")
	private String date_out;
	
	@Column(name="Due_date")
	private String due_date;
	
	@Column(name="Date_in")
	private String date_in;


	public Loan() {}
	
	
	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getDate_out() {
		return date_out;
	}

	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getDate_in() {
		return date_in;
	}

	public void setDate_in(String date_in) {
		this.date_in = date_in;
	}

	@Override
	public String toString() {
		return "Loan [loan_id=" + loan_id + ", isbn=" + isbn + ", card_id=" + card_id + ", date_out=" + date_out
				+ ", due_date=" + due_date + ", date_in=" + date_in + "]";
	}
	
	
}
