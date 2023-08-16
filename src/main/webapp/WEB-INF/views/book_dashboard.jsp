<%@page import="java.util.Base64"%>
<%@page import="book.crud.app.entities.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Dashboard</title>

<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	p {
		width: 500px;
	
	}
	
	table, p {
		margin: auto;
		font-size: 20px;
	}
	
	caption {
		margin-bottom:20px;
		text-decoration: underline;
		color: violet;
	}
	
	th, td {
		padding:5px;
	}
	
	a {
		text-decoration: none;
		width: 200px;
		background-color: dodgerBlue;
		color: white;
		padding: 5px;
		border-radius: 5px;
		margin-left:10px;
	}
	
	
	
</style>
</head>
<body>
	<% 
		List<Book> listOfBooks = (List)request.getAttribute("listOfBooks");
	%>
	
	<table>
		<caption>Books List</caption>
		<tr>
			<th>S. No</th>
			<th>Book Name</th>
			<th>Book Cost</th>
			<th>No of Copies</th>
			<th>Availability</th>
			<th>Book Cover</th>
			<th>Buying Date</th>
			<th>Actions</th>
		</tr>
		
		<!-- Dynamic No of rows depending upon records in the database -->
		
		<% 
			int serialNo = 0;
			for(Book book : listOfBooks) {
				
				String inStock = book.isInStock()?"Yes":"No";
				
				String base64Image = Base64.getEncoder()
						.encodeToString(book.getBookCover());
			%>
		<tr>
			<td><%= book.getBookId() %></td>
			<td><%= book.getBookName() %></td>
			<td><%= book.getBookPrice()%></td>
			<td><%= book.getNoOfCopies()%></td>
			<td><%= inStock%></td>
			
			<td>
				<img src="data:image/jpg;base64, <%= base64Image%>" 
				width="100" height="150"/>
			</td>
			
			<td><%= book.getDateOfPublication()%></td>
			<td>
				<a href="<%= application.getContextPath() %>/book/delete/<%= book.getBookId()%>">Delete</a>
				<a href="<%= application.getContextPath() %>/openUpdateBookPage/<%= book.getBookId()%>">Update</a>
			</td>
		
		</tr>
		<%} %>
		
		<tr>
			<td colspan = "8" style="padding:10px;text-align:center"><a href="openAddBookPage">Add Book</a></td>	
		</tr>
	</table>
	
	<p>
		<% 
			String message = (String)request.getAttribute("message"); 
			if(message!=null) {
				out.print(message);
			}
		%>
	
	</p>
</body>
</html>