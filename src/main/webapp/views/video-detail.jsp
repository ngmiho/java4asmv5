<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${video.title}</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-end mt-2 bg-body-secondary">
			<c:choose>
				<c:when test="${not empty sessionScope.currentUser}">
					<div class="col-md-1 me-2 my-2">
						<a class="btn btn-secondary" href="#"
							style="width: 100px;">Welcome, ${sessionScope.currentUser.username}</a>
					</div>
					<div class="col-md-1 me-2 my-2">
						<a class="btn btn-secondary" href="logout"
							style="width: 100px;">LOG OUT</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-1 me-2 my-2">
						<a class="btn btn-secondary" href="<c:url value='/views/register.jsp'/>"
							style="width: 100px;">SIGN UP</a>
					</div>
					<div class="col-md-1 me-3 my-2">
						<a class="btn btn-secondary" href="<c:url value='/views/login.jsp'/>"
							style="width: 100px;">SIGN IN</a>
					</div>
				</c:otherwise>
			</c:choose>
			
		</div>

		<!-- menu -->
		<%@include file="/views/header.jsp" %>
		<!-- menu -->

		<!-- detail -->
		<%@include file="/views/detail.jsp" %>
		<!-- detail -->

		<!-- footer -->
		<hr>
		<div class="row">
			<div class="col-md-2">
				<img src="img/footer.png" alt="" style="height: 200px;">
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
	<script>
		$('#likeOrUnlikeBtn').click(function() {
			var videoId = $('#videoIdHdn').val();
			$.ajax({
				url: 'video?action=like&id=' + videoId
			}).then(function(data) {
				var text = $('#likeOrUnlikeBtn').text();
				if (text.indexOf('Like') != -1) {
					$('#likeOrUnlikeBtn').text('Unlike');
				} else {
					$('#likeOrUnlikeBtn').text('Like');
				}
			}).fail(function(error) {
				alert('Oops!!! Please try again ^^')
			});
		});
	</script>
</body>
</html>