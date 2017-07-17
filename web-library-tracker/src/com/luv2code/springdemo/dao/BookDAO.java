package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Book;

public interface BookDAO {

	public List<Book> getBooks();

	public void saveBook(Book theBook);
}
