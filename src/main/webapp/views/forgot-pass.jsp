<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-end mt-2 bg-body-secondary">
			<div class="col-md-1 me-2 my-2">
				<a class="btn btn-secondary" href="<c:url value='/views/register.jsp'/>"
					style="width: 100px;">SIGN UP</a>
			</div>
			<div class="col-md-1 me-3 my-2">
				<a class="btn btn-secondary" href="<c:url value='/views/login.jsp'/>"
					style="width: 100px;">SIGN IN</a>
			</div>
		</div>

		<!-- menu -->
		<!-- menu customer -->
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand active" href="index">
					<h1>ONLINE ENTERTAIMENT</h1>
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<c:choose>
							<c:when test="${not empty sessionScope.currentUser}">
								<li class="nav-item"><a class="nav-link"
								href="favorites">MY FAVORITES</a></li>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> MY ACCOUNT </a>
							<ul class="dropdown-menu">
								<c:choose>
									<c:when test="${not empty sessionScope.currentUser}">
										<li><a class="dropdown-item" href="login">Login</a></li>
										<li><a class="dropdown-item" href="register">Registration</a></li>
										<li>
											<hr class="dropdown-divider">
										</li>
									</c:when>
									<c:otherwise>
										<li><a class="dropdown-item"
											href="<c:url value='/views/forgot-password.jsp'/>">Forgot Password</a></li>
										<li>
											<hr class="dropdown-divider">
										</li>
										<li><a class="dropdown-item"
											href="<c:url value='/views/change-password.jsp'/>">Change Password</a></li>
										<li>
											<hr class="dropdown-divider">
										</li>
										<li><a class="dropdown-item"
											href="<c:url value='/views/edit-profile.jsp'/>">Edit Profile</a></li>
										<li><a class="dropdown-item" href="logout">Logoff</a></li>	
									</c:otherwise>
								</c:choose>
								
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- menu customer -->

		<!-- form forgot password -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="row bg-body-secondary py-2">
							<h3 class="fw-1">FORGOT PASSWORD</h3>
						</div>
						<div class="row py-4">
							<div class="mb-3">
								<label for="password" class="form-label">EMAIL?</label> 
								<input type="email" class="form-control"
								name="email" id="email">
							</div>
						</div>
						<div class="row justify-content-md-end bg-body-secondary py-3">
							<div class="col-md-1 me-4">
								<button type="submit" class="btn btn-secondary"
								id="sendBtn">RETRIEVE</button>
							</div>
						</div>
						
						<h5 class="text-danger" id="messageReturn" align="middle"></h5>
				</div>
			</div>
		</div>
		<!-- form forgot password -->

		<!-- footer -->
		<hr>
		<div class="row">
			<div class="col-md-2">
				<img src="/img/footer.png" alt="" style="height: 200px;">
			</div>
			<div class="col-md-10">
				<div class="row justify-content-md-center">
					<div class="col-md-6 bg-body-secondary offset-6"
						style="height: 65px"></div>
					<div class="col-md-auto mt-4" style="height: 65px">OE -
						Online Entertaiment - copyright</div>
					<div class="col-md-12 bg-secondary" style="height: 65px;"></div>
				</div>
			</div>
		</div>
		<!-- footer -->
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>
	<script src="js/index.js"></script>
</body>
<script>
	$('#sendBtn').click(function () {
		$('#messageReturn').text('');
		var email = $('#email').val();
		var formData = {'email' : email};
		$.ajax({
			url: 'forgotPass',
			type: 'POST',
			data: formData
		}).then(function(data) {
			$('#messageReturn').text('Password has been reset, please check your email');
			setTimeout(function() {
				window.location.href = 'http://localhost:8080/java4asmv5/index';
			}, 5*1000);
		}).fail(function(error) {
			$('#messageReturn').text('Your information is not correct, try again');
		});
	});
</script>
</html>