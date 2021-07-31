<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Student ID: ${ student.studentID}</h3>
<h3>Name: ${student.name }</h3>
<h3>Email: ${student.email }</h3>
<h3>Hobbies: ${student.hobbies }</h3>
<h3>Gender: ${student.gender }</h3>
<h3>Image:  </h3> <img id="image-1" alt="hinh anh" src="images/${student.imageUrl }" style="width: 200px; height: 200px"/>
</body>
</html>