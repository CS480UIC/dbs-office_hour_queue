<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
    
    <br>
    <a href="<c:url value='/oldTa_lists'/>" target="body">Please list all the old ta_lists</a>&nbsp;&nbsp;
 
    <br>
    <a href="<c:url value='/oldCourses'/>" target="body">Please list all the old courses</a>&nbsp;&nbsp;
  
    <br>
    <a href="<c:url value='/oldCourse_students'/>" target="body">Please list all the old course_students</a>&nbsp;&nbsp;
  </body>
</html>
