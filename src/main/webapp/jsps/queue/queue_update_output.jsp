<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update queue</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update queue</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	id_queue: <input type="text" name="id_queue" value="${queue.id_queue }" disabled/>
	<br/>
	student_email: <input type="text" name="student_email" value="${queue.student_email }" disabled/>
	<br/>
	full_name: <input type="text" name="full_name" value="${queue.full_name }" disabled/>
	<br/>
	follow_up: <input type="text" name="follow_up" value="${queue.follow_up }" disabled/>
	<br/>
	queue_date: <input type="text" name="queue_date" value="${queue.queue_date }" disabled/>
	<br/>
	officeHourID: <input type="text" name="officeHourID" value="${queue.officeHourID }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="id_queue" value="${queue.id_queue }"/>
	student_email：<input type="text" name="student_email" value="${form.student_email }"/>
	<span style="color: red; font-weight: 900">${errors.student_email }</span>
	<br/>
	full_name：<input type="text" name="full_name" value="${form.full_name }"/>
	<span style="color: red; font-weight: 900">${errors.student_email }</span>
	<br/>
	follow_up：<input type="text" name="follow_up" value="${form.follow_up }"/>
	<span style="color: red; font-weight: 900">${errors.follow_up }</span>
	<br/>
	queue_date：<input type="text" name="queue_date" value="${form.queue_date }"/>
	<span style="color: red; font-weight: 900">${errors.queue_date }</span>
	<br/>
	officeHourID：<input type="text" name="officeHourID" value="${form.officeHourID }"/>
	<span style="color: red; font-weight: 900">${errors.officeHourID }</span>
	<br/>
	<input type="submit" value="Update queue"/>
</form>

</body>
</html>
