package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {

	@Id
	@Column(name="Aid")
	private int aid;
	
	@Column(name="Isbn")
	private long isbn;
	
	@Column(name="Name")
	private String name;
	
	public Author() {}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", isbn=" + isbn + ", name=" + name + "]";
	}

	
}
