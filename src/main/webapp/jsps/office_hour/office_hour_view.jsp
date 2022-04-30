<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Show  all office hours that occurred after April 1, 2022 </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>id_office_hour</th>
		<th>course_number</th>
		<th>ta_email</th>
		<th>location</th>
		<th>meetup_time</th>
		<th>meetup_date</th>
	</tr>
<c:forEach items="${OfficeHourView}" var="oh_view">
	<tr>
		<td>${oh_view.id_office_hour}</td>
		<td>${oh_view.course_number}</td>
		<td>${oh_view.ta_email}</td>
		<td>${oh_view.location}</td>
		<td>${oh_view.meetup_time}</td>
		<td>${oh_view.meetup_date}</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>
