package book.crud.app.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import book.crud.app.dao.BookDao;
import book.crud.app.entities.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookDao bookDao; 

	@RequestMapping("/add")
	public String addBookRequest(
			@RequestParam("book_name") String bookName,
			@RequestParam("book_price") double bookPrice,
			@RequestParam("no_of_copies") int noOfCopies,
			@RequestParam("date_of_publication") String dateOfPublication,
			@RequestParam("book_cover") MultipartFile bookCover, 
			Model model
			) {
		
		Book book = new Book();
		
		book.setBookName(bookName);
		book.setBookPrice(bookPrice);
		
		if(noOfCopies>0) book.setInStock(true);
		
		book.setNoOfCopies(noOfCopies);
		
		book.setDateOfPublication(LocalDate.parse(dateOfPublication));
		
		try {
			book.setBookCover(bookCover.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(book);
		
		int result = bookDao.insertBook(book);
		System.out.println("Result = " + result);
		if(result>0) {
			List<Book> listOfBooks = bookDao.getListOfBooks();	
			model.addAttribute("listOfBooks", listOfBooks);
			model.addAttribute("message", "Book Added Successfully");
			
			return "book_dashboard";
		} else {
			model.addAttribute("message", "Book cannot be added");
			return "book_add";
		}
	}
	
	@RequestMapping("/update/{bookId}")
	public ModelAndView updateBookRequest(
			@RequestParam("book_price") double bookPrice,
			@RequestParam("no_of_copies") int noOfCopies,
			@PathVariable("bookId") int bookId
			) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookPrice(bookPrice);
		book.setNoOfCopies(noOfCopies);
		
		if(noOfCopies==0) book.setInStock(false);
		else book.setInStock(true);
		
		int result = bookDao.updateBook(book);
		
		if(result>0) {
			List<Book> listOfBooks = bookDao.getListOfBooks();	
			
			modelAndView.addObject("listOfBooks", listOfBooks);
			modelAndView.addObject("message", "Book Updated Successfully");
			modelAndView.setViewName("book_dashboard");
		} else {
			modelAndView.addObject("message", "Book could not be Updated");
			modelAndView.setViewName("book_update");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/delete/{bookId}")
	public String deleteBookRequest(
			@PathVariable("bookId") int bookId,
			Model model
			) {
		
		int result = bookDao.deleteBook(bookId);
		
		List<Book> listOfBooks = bookDao.getListOfBooks();	
		model.addAttribute("listOfBooks", listOfBooks);
		
		if(result>0) {
			model.addAttribute("message", "Book deleted successfully");
		} else {
			model.addAttribute("message", "Book cannot be deleted");
		}
		return "book_dashboard";
	}

}
