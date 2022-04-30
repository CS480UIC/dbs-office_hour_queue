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
    
    <br>
    <a href="<c:url value='/oldOffice_hours'/>" target="body">Please list all the old office_hours</a>&nbsp;&nbsp;
    
    <br>
    <a href="<c:url value='/oldQueues'/>" target="body">Please list all the old queues</a>&nbsp;&nbsp;
    
    <br>
    <a href="<c:url value='/oldStudents'/>" target="body">Please list all the old students</a>&nbsp;&nbsp;
    
    <br>
    <a href="<c:url value='/CourseView'/>" target="body">Please list simple query #1</a>&nbsp;&nbsp;
    
   	<br>
    <a href="<c:url value='/OfficeHourView'/>" target="body">Please list simple query #2</a>&nbsp;&nbsp;
    
   	<br>
    <a href="<c:url value='/CourseView2'/>" target="body">Please list complex query #1</a>&nbsp;&nbsp;
   	<br>
    <a href="<c:url value='/TaView'/>" target="body">Please list complex query #2</a>&nbsp;&nbsp;  
 
   	<br>
    <a href="<c:url value='/StudentView'/>" target="body">Please list aggregate query #1</a>&nbsp;&nbsp;   
    
       	<br>
    <a href="<c:url value='/TaView2'/>" target="body">Please list aggregate query #2</a>&nbsp;&nbsp;   
  </body>
</html>
