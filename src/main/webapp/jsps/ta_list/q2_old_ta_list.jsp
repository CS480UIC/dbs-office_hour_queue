<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Old Ta_lists </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>ta_email</th>
		<th>ta_course_number</th>
		<th>ta_course_department</th>
	</tr>
<c:forEach items="${Ta_listList}" var="ta_list">
	<tr>
		<td>${ta_list.ta_email}</td>
		<td>${ta_list.ta_course_number}</td>
		<td>${ta_list.ta_course_department}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
