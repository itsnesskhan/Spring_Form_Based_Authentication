<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/mystyle.css" />'>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1 class="text-center my-5">
		Welcome,
		<sec:authentication property="principal.username" />
	</h1>
	<h1 class="text-center my-5">
		<sec:authentication property="principal.authorities" />
	</h1>
	<h1 class="text-center">
		<sec:authorize access="hasRole('ADMIN')">  
You are ADMIN my friend  </sec:authorize>
	</h1>
	<h1 class="text-center">
		<sec:authorize access="hasRole('TEACHER')">  
You are TEACHER my friend  </sec:authorize>
	</h1>
	<h1 class="text-center">
		<sec:authorize access="hasRole('STUDENT')">  
You are STUDENT my friend  </sec:authorize>
	</h1>
	<h2 class="text-center">Spring Security Pracitce</h2>
	<h3 class="text-center">How's your day</h3>
	<a class="btn btn-primary text-center" href="/api/students">Students API</a>
</body>
</html>