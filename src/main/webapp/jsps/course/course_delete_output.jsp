<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete course</title>
    
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
  <h1>Delete course</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/CourseServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="course_number" value="${course.course_number }"/>
	course_number:<input type="text" name="course_number" value="${course.course_number }" disabled/>
	<br/>
	
	teaching_assistant：<input type="text" name="teaching_assistant" value="${course.teaching_assistant }" disabled />
	<br/>
	
	professor	：<input type="text" name="professor" value="${course.professor }" disabled/>
	<br/>
	
	<input type="submit" value="Delete course"/>
</form>

</body>
</html>
