<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Old Office_hours </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>id_office_hour</th>
		<th>course_number</th>
		<th>ta_email</th>
		<th>location</th>
		<th>meetup_time</th>
		<th>meetup_date</th>
	</tr>
<c:forEach items="${Office_hourList}" var="office_hour">
	<tr>
		<td>${office_hour.id_office_hour}</td>
		<td>${office_hour.course_number}</td>
		<td>${office_hour.ta_email}</td>
		<td>${office_hour.location}</td>
		<td>${office_hour.meetup_time}</td>
		<td>${office_hour.meetup_date}</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>
