<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Shopping Cart</h2>
	<hr />

	<table>
		<tr>
			<td>No.</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td></td>
		</tr>
	<c:set var="no" value="1"/>
		<c:forEach var="item" items="${ cartItems}" varStatus="counter">
			<form action="/shoppingCart/update" method="POST">
				<tr>
					<td>${no }</td>
					
					<td>${item.name }</td>
					<td>
					<input type="hidden" name="productID" value="${item.productID }"/>
					<input type="number" value="${item.quantity }" name="quantity"
						onblur="this.form.submit()"
					/>					
					
					</td>
					<td>${item.price }</td>
					<td><a href="/shoppingCart/remove/${item.productID }">
							Remove </a>
							</td>
				</tr>
			</form>
			<c:set var="no" value="${no + 1 }"/>
		</c:forEach>
	</table>
	
	<a href="/products/list">Product List</a>
	<a href="/shoppingCart/checkout">Checkout</a>
</body>
</html>