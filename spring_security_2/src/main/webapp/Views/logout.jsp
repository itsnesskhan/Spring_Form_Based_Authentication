<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/mystyle.css" />'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">




</head>
<body>
	<div class="container">
		<div class="card">
			<c:if test="${param.error != null }">
				<div class="alert alert-danger">Username or Password is
					Invalid!</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out
					successfully!</div>
			</c:if>

			<form action='<c:url value="/logout?error" />' method="post">
				<div class="sign-in">
					<button type="submit">logout</button>
				</div>
			</form>

		</div>

	</div>
</body>
</html>