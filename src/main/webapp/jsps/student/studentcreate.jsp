<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Student Create</title>
    
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
  <h1>Student Create</h1>
  
<form action="<c:url value='/StudentServletCreate'/>" method="post">
	student_email    :<input type="text" name="student_email" value="${form.student_email }"/>
	<span style="color: red; font-weight: 900">${errors.student_email }</span>
	<br/>
	
	full_name：<input type="text" name="full_name" value="${form.full_name }"/>
	<span style="color: red; font-weight: 900">${errors.full_name }</span>
	<br/>
	note	：<input type="text" name="note" value="${form.note }"/>
	<span style="color: red; font-weight: 900">${errors.note }</span>
	<br/>
	
	queueID	：<input type="text" name="queueID" value="${form.queueID }"/>
	<span style="color: red; font-weight: 900">${errors.queueID }</span>
	<br/>
	
		
	is_ta	：<input type="text" name="is_ta" value="${form.is_ta }"/>
	<span style="color: red; font-weight: 900">${errors.is_ta }</span>
	<br/>
	
	<input type="submit" value="Create Student"/>
</form>
  </body>
</html>
