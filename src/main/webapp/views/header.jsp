<!-- menu customer -->
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand active" href="<c:url value='/index'/>">
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
						<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> MY ACCOUNT </a>
							<ul class="dropdown-menu">
								<c:choose>
									<c:when test="${not empty sessionScope.currentUser}">
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
									</c:when>
									<c:otherwise>
										<li><a class="dropdown-item" href="login">Login</a></li>
										<li><a class="dropdown-item" href="register">Registration</a></li>
										<li>
											<hr class="dropdown-divider">
										</li>
										<li><a class="dropdown-item"
											href="<c:url value='/views/forgot-pass.jsp'/>">Forgot Password</a></li>
									</c:otherwise>
								</c:choose>
								
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- menu customer -->