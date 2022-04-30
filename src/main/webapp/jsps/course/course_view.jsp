<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> All courses greater than 300 level </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>course_number</th>
		<th>teaching_assistant</th>
		<th>professor</th>
	</tr>
<c:forEach items="${CourseViewList}" var="course_view">
	<tr>
		<td>${course_view.course_number}</td>
		<td>${course_view.teaching_assistant}</td>
		<td>${course_view.professor}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
