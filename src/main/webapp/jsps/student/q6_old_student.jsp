<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Old Students </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>student_email</th>
		<th>full_name</th>
		<th>note</th>
		<th>is_ta</th>
		<th>queueID</th>
	</tr>
<c:forEach items="${StudentList}" var="student">
	<tr>
		<td>${student.student_email}</td>
		<td>${student.full_name}</td>
		<td>${student.note}</td>
		<td>${student.is_ta}</td>
		<td>${student.queueID}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
