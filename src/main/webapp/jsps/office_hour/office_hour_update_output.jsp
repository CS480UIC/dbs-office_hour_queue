<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update office_hour</title>
    
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
  <h1>Update office_hour</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	id_office_hour: <input type="text" name="id_office_hour" value="${office_hour.id_office_hour }" disabled/>
	<br/>
	course_number: <input type="text" name="course_number" value="${office_hour.course_number }" disabled/>
	<br/>
	ta_email: <input type="text" name="ta_email" value="${office_hour.ta_email }" disabled/>
	<br/>
	location: <input type="text" name="location" value="${office_hour.location }" disabled/>
	<br/>
	meetup_time: <input type="text" name="meetup_time" value="${office_hour.meetup_time }" disabled/>
	<br/>
	meetup_date: <input type="text" name="meetup_date" value="${office_hour.meetup_date }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="id_queue" value="${office_hour.id_queue }"/>
	course_number：<input type="text" name="course_number" value="${form.course_number }"/>
	<span style="color: red; font-weight: 900">${errors.course_number }</span>
	<br/>
	ta_email：<input type="text" name="ta_email" value="${form.ta_email }"/>
	<span style="color: red; font-weight: 900">${errors.ta_email }</span>
	<br/>
	location：<input type="text" name="location" value="${form.location }"/>
	<span style="color: red; font-weight: 900">${errors.location }</span>
	<br/>
	meetup_time：<input type="text" name="meetup_time" value="${form.meetup_time }"/>
	<span style="color: red; font-weight: 900">${errors.meetup_time }</span>
	<br/>
	meetup_date：<input type="text" name="meetup_date" value="${form.meetup_date }"/>
	<span style="color: red; font-weight: 900">${errors.meetup_date }</span>
	<br/>
	<input type="submit" value="Update office_hour"/>
</form>

</body>
</html>
