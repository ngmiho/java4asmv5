<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-end mt-2 bg-body-secondary">
			<c:choose>
				<c:when test="${not empty sessionScope.currentUser}">
					<div class="col-md-1 me-2 my-2">
						<button class="btn btn-secondary" 
						data-bs-toggle="modal" data-bs-target="#changePassModal">
							Welcome ${sessionScope.currentUser.username}
						</button>
					</div>
					<div class="col-md-1 me-4 my-4">
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
		<!-- Modal -->
		<div class="modal fade" id="changePassModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content bg-body-secondary">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Change password</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <div class="row">
				<div class="col-md-12">
					<div class="row py-4">
						<div class="mb-3">
							<input name="currentPass" id="currentPass" type="password" class="form-control" placeholder="Current password" required/>
						</div>
						<div class="mb-3">
							<input name="newPass" id="newPass" type="password" class="form-control" placeholder="New password" required/>
						</div>
					</div>
					<h5 class="text-danger" id="messageChangePass"></h5>
				</div>
			</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-secondary"
		        id="changePassBtn">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- Modal -->
		
		

		<!-- menu -->
		<%@include file="/views/header.jsp" %>
		<!-- menu -->
		
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-secondary">List Video</h1>
			</div>
		</div>
		
		<!-- item -->
		<%@include file="/views/item.jsp" %>
		<!-- item -->

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
	<!-- 
	<script>
			$('#changePassBtn').click(function () {
				$('#messageChangePass').text('');
				var currentPass = $('#currentPass').val();
				var newPass = $('#newPass').val();
				var formData = {
						'currentPass' : currentPass,
						'newPass' : newPass
				};
				$.ajax({
					url: 'changePass',
					type: 'POST',
					data: formData
				}).then(function(data) {
					$('#messageChangePass').text('Your password has been changed successfylly');
				}).fail(function(error) {
					$('#messageChangePass').text('Your password is not correct, try again');
				});
			});
	</script>
	 -->
</body>
</html>