<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Old Course_students </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>student_email</th>
		<th>course_number</th>
	</tr>
<c:forEach items="${Course_studentList}" var="course_student">
	<tr>
		<td>${course_student.student_email}</td>
		<td>${course_student.course_number}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
