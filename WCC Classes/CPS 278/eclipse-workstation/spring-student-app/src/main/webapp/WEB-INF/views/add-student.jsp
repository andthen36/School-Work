<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>Please enter student info:</b>
		<form:form action = "processStudent" modelAttribute = "student" method="post">
		<form:hidden path="id"/>
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value = "Save Student"/></td>
				</tr>
			</table>
<a href = ${pageContext.request.contextPath}/student/list>Back to Student List</a>
		</form:form>
</body>
</html>