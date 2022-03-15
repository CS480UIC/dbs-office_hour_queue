<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Student</title>
    
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
  <h1>Update Student</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	student_email:<input type="text" name="student_email" value="${entity1.student_email }" disabled/>
	<br/>
	
	full_name：<input type="text" name="full_name" value="${entity1.full_name }" disabled />
	<br/>
	
	note	：<input type="text" name="note" value="${entity1.note }" disabled/>
	<br/>
	
	is_ta	：<input type="text" name="is_ta" value="${entity1.is_ta }" disabled/>
	<br/>
	
	queueID	：<input type="text" name="queueID" value="${entity1.queueID }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${entity1.username }"/>
	Password：<input type="password" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Email	：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Update Student"/>
</form>

</body>
</html>
