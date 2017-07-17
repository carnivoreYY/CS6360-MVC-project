package com.luv2code.springdemo.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Loan;

@Repository
public class LoanDAOImpl implements LoanDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String keywords;
	
	private long tempId;
	
	private boolean checked = false;
	
	private boolean maxTimes = false;
	
	private int cid = 0;

	@Override
	public List<Loan> getLoans() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Loan where isbn = '" + tempId + "'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
	    if (checked || maxTimes) {

	    	return new LinkedList<Loan>();
	    	
	    }
		
	    List<Loan> loans = theQuery.getResultList();
	    
	    return loans;
			
	}

	@Override
	public void saveLoans(Loan theLoan) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String date_out = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		
		String month = date_out.substring(0, 3);
		
		String day = String.valueOf(Integer.valueOf(date_out.substring(3, 5)) + 14);
		
		String year = date_out.substring(5, 10);
		
		String due_date = month + day + year;
		
		theLoan.setDate_out(date_out);
		
		theLoan.setDue_date(due_date);
		
		String sql = "from Loan where card_id = '" + theLoan.getCard_id() + "'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
		List<Loan> loans = theQuery.getResultList();
		
		if (loans.size() >= 3) {
			
			maxTimes = true;
			
		} else {
			
			maxTimes = false;
		}
		
		if (checked || maxTimes) {
			
			return;
			
		}
		
		currentSession.saveOrUpdate(theLoan);
		
	}

	@Override
	public Loan getLoans(long theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		tempId = theId;
		
        String sql = "from Loan where isbn = '" + theId + "'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
		List<Loan> loans = theQuery.getResultList();
		
		Loan theLoan = loans.get(0);
		
		cid = theLoan.getCard_id();
		
		if (cid != 0) {
			
			checked = true;
			
		} else {
			
			checked = false;
			
		}
		
		return theLoan;
	}

	@Override
	public void saveLoan(Loan theLoan) {

		keywords = theLoan.getDate_out();
	}

	@Override
	public List<Loan> getLoan() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Loan where isbn like concat('%', ?1, '%') and card_id != '0'"
				   + "or loan_id like concat('%', ?1, '%') and card_id != '0'"
				   + "or card_id like concat('%', ?1, '%') and card_id != '0'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
		theQuery.setParameter(1, keywords);
		
		List<Loan> theLoans = theQuery.getResultList();
		
		return theLoans;
	}

	@Override
	public List<Loan> updateLoan(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Loan where loan_id = '" + theId + "'";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
		List<Loan> theLoan = theQuery.getResultList();
		
		Loan loan = theLoan.get(0);
		
		String date_in = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		
		loan.setDate_in(date_in);
		
		loan.setCard_id(0);
		
		currentSession.saveOrUpdate(loan);
		
		List<Loan> loans = new LinkedList<Loan>();
		
		loans.add(loan);
		
		return loans;
		
	}

}
