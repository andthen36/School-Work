<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStyle.css">
</head>
<body>
	<div class = "form-style-1">
	<form:form action = "processForm" modelAttribute = "mortgage">
	<form:label path="principle">Principal:<span class="required"></span></form:label>
		<form:input path="principle" />
		<form:errors path = "principle" cssClass = "error"/>
		<br>
		<form:label path="downPayment">Down Payment:<span class="required">
		</form:label>
		<form:input path="downPayment" />
		<form:errors path = "downPayment" cssClass = "error"/><br>
		<form:label path="interest">Interest:<span class="required">
		</form:label>
		<form:input path="interest" />
		<form:errors path = "interest" cssClass = "error"/><br>
		<form:label path="loanTerm">Loan Term:<span class="required">
		</form:label>
		<form:input path="loanTerm" />
		<br>
		<input type = "submit" value = "Submit"/>
	</form:form>
	</div>
</body>
</html>