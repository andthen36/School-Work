<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello World!
<c:set var="courseName" value = "CPS278"> </c:set>
<c:out value="${courseName }"></c:out><br>
<c:forEach var ="i" items = "1,2,3,4,5">
<c:out value="${i}"></c:out><br>
</c:forEach>
<c:forEach var = "eachCourse" items="${courseList}">
<c:out value="${eachCourse}"></c:out>
</c:forEach>
</body>
</html>