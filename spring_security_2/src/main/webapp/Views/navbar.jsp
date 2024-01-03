<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg navbar-light mynave">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><span
			class="fas fa-blog fa-lg fa-fw"></span>Blog</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"><span
						class="fas fa-info-circle fa-sm fa-fw"></span>About</a></li>
				<li class="nav-item"><a class="nav-link" href="profile.jsp"><span
						class="fas fa-user-circle fa-sm fa-fw"></span>Profile</a></li>

				<li class="nav-item"><a class="nav-link" href="signup.jsp"><span
						class="fas fa-user-plus fa-sm fa-fw"></span>Register</a></li>
				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item"><a class="nav-link " href="login.jsp"><span
							class="fas fa-sign-in fa-sm fa-fw"></span>Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link "
						href='<c:url value="/logout"/>'><span
							class="fas fa-sign-in fa-sm fa-fw"></span>Logout</a></li>
				</sec:authorize>


			</ul>
		</div>
	</div>
</nav>