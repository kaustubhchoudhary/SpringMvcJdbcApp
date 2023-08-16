package book.crud.app.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import book.crud.app.entities.Book;

public class RowMapperImpl implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {		
		Book book = new Book();
		book.setBookId(rs.getInt("bookId"));
		book.setBookName(rs.getString("bookName"));
		book.setBookPrice(rs.getDouble("bookPrice"));
		book.setNoOfCopies(rs.getInt("noOfCopies"));
		book.setInStock(rs.getBoolean("inStock"));
		
		// java.sql.Date -> java.time.LocalDate
		book.setDateOfPublication(
				rs.getDate("dateOfPublication").toLocalDate());
		
		// Converting Blob into byte[]
		Blob bookCover = rs.getBlob("bookCover");
		book.setBookCover(bookCover.getBytes(1, (int)bookCover.length()));
		
		return book;
	}

}
