package com.luv2code.springdemo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Fines;
import com.luv2code.springdemo.entity.Loan;
import com.luv2code.springdemo.entity.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> getPayments() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Payment";
		
		Query<Payment> theQuery = currentSession.createQuery(sql, Payment.class);
		
		List<Payment> thePayments = theQuery.getResultList();
		
		return thePayments;
	}

	@Override
	public void savePayments(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql1 = "from Loan where loan_id = '" + theId + "'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql1, Loan.class);
		
		List<Loan> theLoans = theQuery.getResultList();
		
		Loan theLoan = theLoans.get(0);
		
		int cid = theLoan.getCard_id();
		
		String sql2 = "from Fines where loan_id = '" + theId + "'";
		
		Query<Fines> query = currentSession.createQuery(sql2, Fines.class);
		
		List<Fines> theFines = query.getResultList();
		
	    Fines theFine = theFines.get(0);
	    
	    BigDecimal temp = theFine.getFine_amt();
	    
	    Session session = sessionFactory.getCurrentSession();
	    
	    String sql = "from Payment where card_no = '" + cid + "'";
	    
	    Query<Payment> q = session.createQuery(sql, Payment.class);
	    
	    List<Payment> thePayments = q.getResultList();
	    
	    if (thePayments.size() == 0) {
	    	
	    	Payment payment = new Payment();
	    	
	    	payment.setCard_no(cid);
	    	
	    	payment.setAmount(temp);
	    	
	    	session.save(payment);
	    	
	    } else {
	    	
	    	Payment thePayment = thePayments.get(0);
	    	
	    	temp = temp.add(thePayment.getAmount());
	    	
	    	thePayment.setAmount(temp);
	    	
	    	session.saveOrUpdate(thePayment);
	    	
	    }
		
	}
}
