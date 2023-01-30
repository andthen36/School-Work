<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css">
</head>
<body>
<p><strong>Monthly Payment:</strong>${mortgage.monthlyPayment}</p>
<div class="form-style-1">
	<table>
		<tr>
			<th>Payment No.</th>
			<th>Principal Paid</th>
			<th>Interest Paid</th>
			<th>Outstanding Balance</th>
		</tr>
		<c:forEach var = "eachPayment" items = "${mortgage.paymentList}">
		<tr>
			<td>${eachPayment.paymentNumb}</td>
			<td>${eachPayment.principalPaid}</td>
			<td>${eachPayment.interestPaid}</td>
			<td>${eachPayment.outstanding}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>