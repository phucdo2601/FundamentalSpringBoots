<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Details</h1>
	<hr/>
	<h3>Student ID: ${studentID}</h3>
	<h3>Student Name: ${name}</h3>
	
	<p>
		<a href="/students/edit/${studentID}">Edit Student</a>
	</p>
	<hr/>
	<a href="/">Home</a>
</body>
</html>