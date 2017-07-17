package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Borrower;

@Repository
public class BorrowerDAOImpl implements BorrowerDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	String SSN;
	
	int temp_id = 1001;
	
	List<Borrower> borrowers;
	
	@Override
	public List<Borrower> getBorrowers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Borrower where Ssn = '" + SSN + "'";
		
		Query<Borrower> theQuery = currentSession.createQuery(sql, Borrower.class);
		
		borrowers = theQuery.getResultList();    
		
		return borrowers;
	}

	@Override
	public void saveBorrower(Borrower theBorrower) {
		
		String temp = theBorrower.getSsn();
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Borrower where Ssn = '" + temp + "'";
		
		Query<Borrower> theQuery = currentSession.createQuery(sql, Borrower.class);
		
		borrowers = theQuery.getResultList(); 

		if (borrowers.size() == 0) {
			SSN = temp;
			
			theBorrower.setCard_id(temp_id);
			
			temp_id++;
			
			currentSession.save(theBorrower);
		}
		
	}


}
