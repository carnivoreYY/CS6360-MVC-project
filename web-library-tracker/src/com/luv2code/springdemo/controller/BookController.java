package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Book;
import com.luv2code.springdemo.entity.Borrower;
import com.luv2code.springdemo.entity.Loan;
import com.luv2code.springdemo.entity.Payment;
import com.luv2code.springdemo.service.BookService;
import com.luv2code.springdemo.service.BorrowerService;
import com.luv2code.springdemo.service.FinesService;
import com.luv2code.springdemo.service.LoanService;
import com.luv2code.springdemo.service.PaymentService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowerService borrowerService;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private FinesService finesService;
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping("/borrower")
	public String showBorrowers(Model theModel) {
		
		List<Borrower> theBorrowers = borrowerService.getBorrowers();
		
		if (theBorrowers.size() == 0) {
			return "error-page-borrower";
		}
		
		theModel.addAttribute("borrowers", theBorrowers);
		
		return "borrower-list";
	}
	
	@RequestMapping("/list")
	public String showBooks(Model theModel) {
		
		List<Book> theBooks = bookService.getBooks();
		
		theModel.addAttribute("books", theBooks);
		
		return "list-books";
	}
	
	@RequestMapping("/loans")
	public String showLoans(Model theModel) {
		
		List<Loan> theLoans = loanService.getLoan();
		
		theModel.addAttribute("loans", theLoans);
		
		return "check-books";
		
	}
	
	@RequestMapping("/check")
	public String checkBooks(Model theModel) {
		
		List<Loan> theLoans = loanService.getLoans();
		
		if (theLoans.size() == 0) {
			return "error-page";
		}
		
		return "check-confirm";                
	}
	
	@RequestMapping("/showPayments")
	public String showPayments(Model theModel) {
		
		List<Payment> thePayments = paymentService.getPayments();
		
		theModel.addAttribute("payments", thePayments);
		
		return "payments-list";
	}
	
	@GetMapping("/show")
	public String show(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "search-form";
	}
	
	@GetMapping("/searchLoan")
	public String searchLoan(Model theModel) {
		
		finesService.saveFines();
		
		Loan theLoan = new Loan();
		
		theModel.addAttribute("loan", theLoan);
		
		return "loan-search";
	}
	
	@GetMapping("/add")
	public String addBorrower(Model theModel) {
		
		Borrower theBorrower = new Borrower();
		
		theModel.addAttribute("borrower", theBorrower);
		
		return "add-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		bookService.saveBook(theBook);
		
		return "redirect:/book/list";
	}
	
	@PostMapping("/showLoan")
	public String showLoan(@ModelAttribute("loan") Loan theLoan) {
		
		loanService.saveLoan(theLoan);
		
		return "redirect:/book/loans";
		
	}

	@PostMapping("/saveBorrower")
	public String saveBorrower(@Valid @ModelAttribute("borrower") Borrower theBorrower,
			                   BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			
			return "add-form";
		}
		
		borrowerService.saveBorrower(theBorrower);
		
		return "redirect:/book/borrower";
	}
	
	@PostMapping("/saveLoan")
	public String saveLoan(@ModelAttribute("loan") Loan theLoan) {
		
		loanService.saveLoans(theLoan);
		
		return "redirect:/book/check";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("bookId") long theId,
			                     Model theModel) {
		
		Loan theLoan = loanService.getLoans(theId);
		
		theModel.addAttribute("loan", theLoan);
		
		return "check-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("loanId") int theId,
			                        Model theModel) {
		
		paymentService.savePayments(theId);
		
		List<Loan> theLoans = loanService.updateLoan(theId);
		
		theModel.addAttribute("loans", theLoans);
		
		return "check-in";
	}
	
}
