<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Student Output</title>
    
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
  <h1>Read Student Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	student_email:<input type="text" name="student_email" value="${student.student_email }" disabled/>
	<br/>
	
	full_name：<input type="text" name="full_name" value="${student.full_name }" disabled />
	<br/>
	
	note	：<input type="text" name="note" value="${student.note }" disabled/>
	<br/>
	
	queueID	：<input type="text" name="queueID" value="${student.queueID }" disabled/>
	<br/>
	
	is_ta	：<input type="text" name="is_ta" value="${student.is_ta }" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
