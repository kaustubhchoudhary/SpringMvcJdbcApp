<%@page import="book.crud.app.entities.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Update</title>
<style>
	form {
		width: 400px;
		margin:auto;
	}
	
	input {
		margin-bottom: 10px;
	}
	
	legend 
	{
        width: 120px;
        padding: 2px;
        margin-left: calc(50% - 35px - 10px);
    }
	
</style>

</head>
<body>
	<% 
		Book book = (Book)request.getAttribute("bookToUpdate");
		out.print(book);
		
	%>

	<form action="<%= request.getContextPath() %>/book/update/<%= book.getBookId() %>" method="get">
		<fieldset>
			<legend>Update Book Form</legend>
			<input disabled type="text" name="book_name" value="<%= book.getBookName() %>" placeholder="Enter Book Name"/><br/>
			<input type="text" name="book_price" value="<%= book.getBookPrice() %>" placeholder="Enter Book Price"/><br/>
			<input type="text" name="no_of_copies" value="<%= book.getNoOfCopies() %>" placeholder="Enter No of Copies"/><br/>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
	<h3><a href="openBookDashBoardPage">Go to Books List</a></h3>

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