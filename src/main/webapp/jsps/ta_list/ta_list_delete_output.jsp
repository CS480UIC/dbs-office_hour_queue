<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete ta_list</title>
    
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
  <h1>Delete ta_list</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Ta_listServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="ta_email" value="${ta_list.ta_email }"/>
	ta_email:<input type="text" name="ta_email" value="${ta_list.ta_email }" disabled/>
	<br/>
	
	ta_course_number：<input type="text" name="ta_course_number" value="${ta_list.ta_course_number }" disabled />
	<br/>
	
	ta_course_department	：<input type="text" name="ta_course_department" value="${ta_list.ta_course_department }" disabled/>
	<br/>
	
	<input type="submit" value="Delete ta_list"/>
</form>

</body>
</html>
