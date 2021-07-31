<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/"/>
</head>
<body>
	<h1>List of Students</h1>
	<hr />
	<table id="table-1">
		<tr>
			<td>Student ID</td>
			<td>Name</td>
			<td></td>
		</tr>
		<c:forEach items="${students}" var="dto">
			<tr>
				<td>${dto.studentID }</td>
				<td>${dto.name }</td>
				<td>
				<a href="students/viewDetail/${dto.studentID }">View</a>
				<a href="students/edit/${dto.studentID }">Edit</a>
				<a href="students/delete/${dto.studentID }">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>