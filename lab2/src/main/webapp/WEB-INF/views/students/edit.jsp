<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/">
</head>
<body>
	<h1>Edit the students</h1>
	
	<hr/>
	
	<form action="students/update" method="post">
		Student id: <input type="text" name="studentID" value="${student.studentID}"/> </br>
		Student name: <input type="text" name="name" value="${student.name}"/> </br>
		
		<button>Update</button>
		<button formmethod="get" formaction="students/list">List</button>
		<button formmethod="get" formaction="students/search">Search</button>
		
	</form>
</body>
</html>