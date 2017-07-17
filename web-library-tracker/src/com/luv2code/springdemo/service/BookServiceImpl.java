package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.BookDAO;
import com.luv2code.springdemo.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	

	@Override
	@Transactional
	public List<Book> getBooks() {

		return bookDAO.getBooks();
	}



	@Override
	@Transactional
	public void saveBook(Book theBook) {

		bookDAO.saveBook(theBook);
	}

}
