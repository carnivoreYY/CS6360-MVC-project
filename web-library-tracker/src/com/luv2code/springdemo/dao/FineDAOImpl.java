package com.luv2code.springdemo.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Fines;
import com.luv2code.springdemo.entity.Loan;

@Repository
public class FineDAOImpl implements FinesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveFines() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from Loan where card_id != '0'"
				   + "or card_id = '0' and date_in != null";
		
		Query<Loan> theQuery = currentSession.createQuery(sql, Loan.class);
		
		List<Loan> theLoans = theQuery.getResultList();
		
		for (Loan loan : theLoans) {
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			
			Date startDate = new Date();
			
			Date endDate = new Date();
			
			Fines fines = new Fines();
			
			int l_id = loan.getLoan_id();
			
			fines.setLoan_id(l_id);
			
			String date_in = loan.getDate_in();
			
			String date_out = loan.getDate_out();
			

			try {
				startDate = df.parse(date_out);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
			
			if (date_in == null) {
				
				try {
					endDate = df.parse(currentDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				int diffInDays = (int)( (endDate.getTime() - startDate.getTime()) 
		                 / (1000 * 60 * 60 * 24) );
				
				double value = ((double) diffInDays) * 0.25;
				
				BigDecimal amt = new BigDecimal(value);
				
				fines.setFine_amt(amt);
				
				fines.setPaid(0);
				
			} else {
				
				try {
					endDate = df.parse(date_in);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				int diffInDays = (int)( (endDate.getTime() - startDate.getTime()) 
		                 / (1000 * 60 * 60 * 24) );
				
				double value = ((double) diffInDays) * 0.25;
				
				BigDecimal amt = new BigDecimal(value);
				
				fines.setFine_amt(amt);
				
				fines.setPaid(1);
				
			}
			
			currentSession.saveOrUpdate(fines);
			
		}
	
	}

}
