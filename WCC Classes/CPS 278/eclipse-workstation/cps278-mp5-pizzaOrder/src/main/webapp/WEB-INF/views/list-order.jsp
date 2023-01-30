<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
</head>
<body>
<h2> Orders for ${customerName}</h2>

	<table>
		
	<c:forEach var="eachOrder" items="${orders}">
				<table>
					<tr>
						<th> Order Id </th>
						<th width = 60> Size</th>
						<th>Toppings</th>
					</tr>
					<c:forEach var="eachPizza" items="${eachOrder.pizzaList}">
						<tr>
							<td>${eachOrder.id}</td>
							<td>${eachPizza.size}</td>
							<td>${eachPizza.toppings}</td>
							<td>
					<form action="deleteOrder" method="post">
						<input type="hidden" name="orderId" value = "${eachOrder.id}"/>
						<input type="submit" value="Delete Order">
					</form>
					</td>
						</tr>
					</c:forEach>
				</table>
				
	</c:forEach>
	</table>
		<div>
			<form action="list" method="get">
				<input type="submit"  value="Back to customer list"/>
			</form>
		</div>
		<form action="orderPizza" method="post">
				<input type="hidden"  name="customerId" value="${customerId}"/>
				<input type="submit"  value="Place another order"/>
			</form>
</body>
</html>