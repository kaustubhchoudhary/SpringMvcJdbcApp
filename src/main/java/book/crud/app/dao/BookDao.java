package book.crud.app.dao;

import java.util.List;

import book.crud.app.entities.Book;

public interface BookDao {

	int insertBook(Book book);

	int updateBook(Book book);

	int deleteBook(int bookId);

	Book getBook(int bookId);

	List<Book> getListOfBooks();

}
