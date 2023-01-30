<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<body>
	<h2>Info:</h2>
	Name: ${order.customer.name}
	<br> Street: ${order.customer.address.street}
	<br> City: ${order.customer.address.city}
	<br> State: ${order.customer.address.state}
	<br> Zip: ${order.customer.address.zip}
	<h2>Pizza Order:</h2>
	Size: ${order.pizza.size}
	<c:forEach var = "eachTopping" items = "${order.pizza.toppings}">
	${eachTopping}&emsp;
	</c:forEach>
</body>
</html>