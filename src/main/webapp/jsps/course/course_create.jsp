<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>course Create</title>
    
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
  <h1>Create course</h1>
  
<form action="<c:url value='/CourseServletCreate'/>" method="post">
	course_number: <input type="text" name="course_number" value="${form.course_number }"/>
	<span style="color: red; font-weight: 900">${errors.course_number }</span>
	<br/>
	teaching_assistant： <input type="text" name="teaching_assistant" value="${form.teaching_assistant }"/>
	<span style="color: red; font-weight: 900">${errors.teaching_assistant }</span>
	<br/>
	professor： <input type="text" name="professor" value="${form.professor }"/>
	<span style="color: red; font-weight: 900">${errors.professor }</span>
	<br/>
	
	<input type="submit" value="Create course"/>
</form>
  </body>
</html>
