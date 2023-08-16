package book.crud.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import book.crud.app.dao.BookDao;
import book.crud.app.entities.Book;

@Controller
public class NavigationController {

	@Autowired
	BookDao bookDao;
	
	@RequestMapping(value = {"/", "/openBookDashBoardPage"})
	public String openBookDashBoardPage(Model model) {
		
		// Step 1: We have to get the list of books from the database
		List<Book> listOfBooks = bookDao.getListOfBooks();	

		// Step 2: We have to pass the books List to book_dashboard.jsp
		model.addAttribute("listOfBooks", listOfBooks);
		
		return "book_dashboard";
	}
	
	@RequestMapping("/openAddBookPage")
	public String openAddBookPage() {
		return "book_add";
	}
	
	@RequestMapping("/openUpdateBookPage/{bookId}")
	public String openUpdateBookPage(
			@PathVariable("bookId") int bookId,
			Model model
			) {
		
		Book bookToUpdate = bookDao.getBook(bookId);
		model.addAttribute("bookToUpdate", bookToUpdate);
		
		return "book_update";
	}
}
