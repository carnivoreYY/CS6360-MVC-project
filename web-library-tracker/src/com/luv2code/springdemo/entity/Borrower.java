package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="borrower")
public class Borrower {


	@Id
	@Column(name="Card_id")
	private int card_id;
	
	@NotEmpty(message="not null")
	@Pattern(regexp="^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", message="must be in the format AAA-GG-SSSS")
	@Column(name="Ssn")
	private String ssn;
	
	@NotEmpty(message="not null")
	@Column(name="Bname")
	private String bname;
	
	@NotEmpty(message="not null")
	@Column(name="Address")
	private String address;
	
	@Column(name="Phone")
	private String phone;

	public Borrower () {}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Borrower [card_id=" + card_id + ", ssn=" + ssn + ", bname=" + bname + ", address=" + address
				+ ", phone=" + phone + "]";
	}


	
}
