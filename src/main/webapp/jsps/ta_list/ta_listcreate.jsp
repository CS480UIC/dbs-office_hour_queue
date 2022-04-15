<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>ta_list Create</title>
    
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
  <h1>ta_list Create</h1>
  
<form action="<c:url value='/Ta_listServletCreate'/>" method="post">
	ta_email    :<input type="text" name="ta_email" value="${form.ta_email }"/>
	<span style="color: red; font-weight: 900">${errors.ta_email }</span>
	<br/>
	ta_course_number：<input type="text" name="ta_course_number" value="${form.ta_course_number }"/>
	<span style="color: red; font-weight: 900">${errors.ta_course_number }</span>
	<br/>
	ta_course_department	：<input type="text" name="ta_course_department" value="${form.ta_course_department }"/>
	<span style="color: red; font-weight: 900">${errors.ta_course_department }</span>
	<br/>
	
	<input type="submit" value="Create ta_list"/>
</form>
  </body>
</html>
