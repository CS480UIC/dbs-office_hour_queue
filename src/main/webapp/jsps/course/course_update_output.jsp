<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update ta_list</title>
    
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
  <h1>Update course</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	course_number: <input type="text" name="ta_email" value="${course.course_number }" disabled/>
	<br/>
	
	teaching_assistant： <input type="text" name="ta_course_number" value="${course.teaching_assistant }" disabled />
	<br/>
	
	professor： <input type="text" name="ta_course_department" value="${course.professor }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="course_number" value="${course.course_number }"/>
	teaching_assistant：<input type="password" name="teaching_assistant " value="${form.teaching_assistant }"/>
	<span style="color: red; font-weight: 900">${errors.teaching_assistant }</span>
	<br/>
	professor	：<input type="text" name="professor" value="${form.professor }"/>
	<span style="color: red; font-weight: 900">${errors.professor }</span>
	<br/>
	<input type="submit" value="Update course"/>
</form>

</body>
</html>
