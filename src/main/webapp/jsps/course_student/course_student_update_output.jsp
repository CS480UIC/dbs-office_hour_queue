<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update course_student</title>
    
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
  <h1>Update course_student</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	student_email:<input type="text" name="student_email" value="${course_student.student_email }" disabled/>
	<br/>
	
	course_number：<input type="text" name="course_number" value="${course_student.course_number }" disabled />
	<br/>

</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Course_studentServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="student_email" value="${course_student.student_email }"/>
				<input type="hidden" name="course_number" value="${course_student.course_number }"/>
				
	student_email：<input type="text" name="student_email" value="${form.student_email }"/>
	<span style="color: red; font-weight: 900">${errors.student_email }</span>
	<br/>
	course_number	：<input type="text" name="course_number" value="${form.course_number }"/>
	<span style="color: red; font-weight: 900">${errors.course_number }</span>
	<br/>
	<input type="submit" value="Update course_student"/>
</form>

</body>
</html>
