<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="table-1">
		
			<tr>
				<td>Product ID</td>
				<td>Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td></td>
			</tr>
			<c:forEach var="items" items="${products }">
			<tr>
				<td>${items.productID }</td>
				<td>${items.name }</td>
				<td>${items.quantity }</td>
				<td>${items.price }</td>
				<td>
					<a href="/shoppingCart/add/${items.productID }">Add To Cart</a>
				</td>
			</tr>
			</c:forEach>
		
	</table>
	
	<a href="/shoppingCart/list">Shopping Cart</a>
</body>
</html>