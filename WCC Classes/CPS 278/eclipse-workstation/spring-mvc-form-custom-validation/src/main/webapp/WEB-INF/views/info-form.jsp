<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myStle.css">
</head>
<body>
	<div class = "form-style-1">
	<form:form action = "processForm" modelAttribute = "customer">
	<form:label path="name">Customer name:<span class="required">*</span></form:label>
		<form:input path="name" />
		<form:errors path = "name" cssClass = "error"/>
		<br>
		<form:label path="age">Customer age:<span class="required">
		</form:label>
		<form:input path="age" />
		<form:errors path = "age" cssClass = "error"/><br>
		<form:label path="zipcode">Customer zipcode:<span class="required">
		</form:label>
		<form:input path="zipcode" />
		<form:errors path = "zipcode" cssClass = "error"/><br>
		<form:label path="favoriteCourse">Favorite course:<span class="required">
		</form:label>
		<form:input path="favoriteCourse" />
		<form:errors path = "favoriteCourse" cssClass = "error"/><br>
		<input type = "submit" value = "Submit"/>
	</form:form>
	</div>
</body>
</html>