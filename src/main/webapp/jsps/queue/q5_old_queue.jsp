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
		<th>id_queue</th>
		<th>student_email</th>
		<th>full_name</th>
		<th>follow_up</th>
		<th>queue_date</th>
		<th>officeHourID</th>
	</tr>
<c:forEach items="${QueueList}" var="queue">
	<tr>
		<td>${queue.id_queue}</td>
		<td>${queue.student_email}</td>
		<td>${queue.full_name}</td>
		<td>${queue.follow_up}</td>
		<td>${queue.queue_date}</td>
		<td>${queue.officeHourID}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
