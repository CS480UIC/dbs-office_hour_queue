<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete queue</title>
    
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
  <h1>Delete queue</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Entity1ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id_queue" value="${queue.id_queue }"/>
	id_queue:<input type="text" name="id_queue" value="${queue.id_queue }" disabled/>
	<br/>
	
	student_email：<input type="text" name="student_email" value="${queue.student_email }" disabled />
	<br/>
	
	full_name：<input type="text" name="full_name" value="${queue.full_name }" disabled />
	<br/>
	
	follow_up：<input type="text" name="follow_up" value="${queue.follow_up }" disabled />
	<br/>
	
	queue_date：<input type="text" name="queue_date" value="${queue.queue_date }" disabled />
	<br/>
	
	officeHourID：<input type="text" name="student_email" value="${queue.officeHourID }" disabled />
	<br/>
	
	<input type="submit" value="Delete queue"/>
</form>

</body>
</html>
