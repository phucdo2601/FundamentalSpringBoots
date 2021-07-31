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
	<h1>New Student</h1>
	<br/>
	<form action="students/saveOrUpdate" method="post">
		Student id: <input type="text" name="studentID"/> </br>
		Student name: <input type="text" name="name"/> </br>
		
		<button>Save</button>
		<button formmethod="get" formaction="students/list">List</button>
		<button formmethod="get" formaction="students/search">Search</button>
		
	</form>
</body>
</html>