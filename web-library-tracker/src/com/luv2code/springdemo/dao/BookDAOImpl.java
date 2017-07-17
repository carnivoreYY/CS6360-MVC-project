package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Author;
import com.luv2code.springdemo.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	String temp;
	
	@Override
	public List<Book> getBooks() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Book where isbn LIKE CONCAT('%',?1,'%')"
				     + "or title LIKE CONCAT('%',?1,'%')";
		
		Query<Book> theQuery = currentSession.createQuery(sql,Book.class);
		
		theQuery.setParameter(1, temp);
		
		List<Book> books = theQuery.getResultList();
		
		HashSet<Long> set = new HashSet<>();
		
		for (Book book : books) {
			
			set.add(Long.valueOf(book.getIsbn()));
		}
		
		String t = temp;
		
		String str = "from Author where name LIKE CONCAT('%',?3,'%')";
		
		Query<Author> q = currentSession.createQuery(str, Author.class);
		
		q.setParameter(3, t);
		
		List<Author> authors = q.getResultList();
		
		List<String> isbns = new ArrayList<>();
		
		for (Author author : authors) {
			
			if (!set.contains(author.getIsbn())) {
				
				isbns.add(String.valueOf(author.getIsbn()));
			}
			
		}
		
		for (String i : isbns) {
			
			String additional = "from Book where isbn ='" + i + "'";
			
			Query<Book> qry = currentSession.createQuery(additional, Book.class);
			
			List<Book> add = qry.getResultList();
			
			books.addAll(add);  
			
		}
		
		for (Book book : books) {
			
			long isbn = Long.valueOf(book.getIsbn());
			
			String s = "from Author where isbn = '" + isbn + "'";
			
			Query<Author> query = currentSession.createQuery(s, Author.class);
			
			List<Author> theAuthors = query.getResultList();
			
			StringBuilder sb = new StringBuilder();
			
			for (Author author : theAuthors) {
				
				sb.append(author.getName());
				
				sb.append(", ");
				
			}
			
			sb.delete(sb.length() - 2, sb.length());
			
			book.setName(sb.toString());
			
		}  
		
		return books;
	}

	@Override
	public void saveBook(Book theBook) {

		temp = theBook.getTitle();
	}

}
