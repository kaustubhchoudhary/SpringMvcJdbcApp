package book.crud.app.entities;

import java.time.LocalDate;

public class Book {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private int noOfCopies;
	private boolean inStock;
	private LocalDate dateOfPublication;
	private byte[] bookCover;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, double bookPrice, int noOfCopies, boolean inStock,
			LocalDate dateOfPublication, byte[] bookCover) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.noOfCopies = noOfCopies;
		this.inStock = inStock;
		this.dateOfPublication = dateOfPublication;
		this.bookCover = bookCover;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public LocalDate getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(LocalDate dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public byte[] getBookCover() {
		return bookCover;
	}

	public void setBookCover(byte[] bookCover) {
		this.bookCover = bookCover;
	}

	@Override
	public String toString() {
		return "\n Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", noOfCopies="
				+ noOfCopies + ", inStock=" + inStock + ", dateOfPublication=" + dateOfPublication + "]";
	}

}
