<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Add</title>
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
        width: 110px;
        padding: 5px;
        margin-left: calc(50% - 25px - 10px);
    }
	
</style>

</head>
<body>
	<form action="book/add" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Add Book Form</legend>
			<input type="text" name="book_name" placeholder="Enter Book Name"/><br/>
			<input type="text" name="book_price" placeholder="Enter Book Price"/><br/>
			<input type="text" name="no_of_copies" placeholder="Enter No of Copies"/><br/>
			<input type="date" name="date_of_publication" placeholder="mm/dd/yyyy"/><br/>
			<input type="file" name="book_cover"/>
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