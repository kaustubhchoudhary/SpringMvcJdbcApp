package book.crud.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import book.crud.app.entities.Book;

public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertBook(Book book) {
		String insertQuery = "INSERT INTO "
				+ "books "
				+ "(bookName, bookPrice, noOfCopies, "
				+ "inStock, dateOfPublication, bookCover ) "
				+ "VALUES (?,?,?,?,?,?)";

		return this.jdbcTemplate.update(
				insertQuery, book.getBookName(), book.getBookPrice(), 
				book.getNoOfCopies(), book.isInStock(), 
				book.getDateOfPublication(), book.getBookCover());
	}

	public List<Book> getListOfBooks() {
		String fetchAllSBooksQuery = "SELECT * FROM books";	
		// RowMapper
		return this.jdbcTemplate.query(
				fetchAllSBooksQuery, new RowMapperImpl());
	}

	public int updateBook(Book book) {
		String updateQuery = "UPDATE books "
				+ "SET bookPrice = ?, noOfCopies = ?, "
				+ "inStock = ? WHERE bookId = ?";
		
		return this.jdbcTemplate.update(updateQuery, 
				book.getBookPrice(), book.getNoOfCopies(),
				book.isInStock(), book.getBookId());
	}

	public int deleteBook(int bookId) {
		String deleteBookQuery = "DELETE FROM books WHERE bookId = ?";
		return this.jdbcTemplate.update(deleteBookQuery, bookId);
	}

	public Book getBook(int bookId) {
		String getSingleBook = "SELECT * from books WHERE bookId = ?";

		return this.jdbcTemplate.queryForObject(getSingleBook, 
				new RowMapperImpl(), bookId);
	}

}
