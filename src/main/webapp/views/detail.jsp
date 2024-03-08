<!-- detail -->
		<div class="row bg-body-tertiary">
			<div class="col-md-8">
				<ul class="list-group border border-black border-3">
					<li class="list-group-item">
						<div class="card">
							<iframe class="card-img-top" style="height: 500px"
							src="https://www.youtube.com/embed//${video.href}"></iframe>
						</div>
					</li>
					<li class="list-group-item bg-body-secondary">
						<h3>${video.title}</h3>
					</li>
					<li class="list-group-item">
						<div style="height: 202px">DESCRIPTION</div>
						<div>${item.detail}</div>
					</li>
					<li class="list-group-item bg-body-secondary">
						<div class="d-flex justify-content-md-end">
							<c:if test="${not empty sessionScope.currentUser}">
								<button class="btn btn-secondary me-2"
								id="likeOrUnlikeBtn">
									<c:choose>
											<c:when test="${flagLikedBtn == true}">
												Unlike
											</c:when>
											<c:otherwise>
												Like
											</c:otherwise>
									</c:choose>
								</button>
								<button class="btn btn-secondary">SHARE</button>
							</c:if>
						</div>
						<input id="videoIdHdn" type="hidden" value="${video.href}">
					</li>
				</ul>
				
			</div>
			<div class="col-md-4">
				<div class="row">
					<c:forEach var="item" items="${sessionScope.lstVideo}">
						<div class="col-md-12">
							<div class="card">
								<div class="row">
									<div class="col-md-6">
										<div class="card">
											<iframe class="card-img-top" style="height: 200px"
											src="http://www.youtube.com/embed/${item.href}"></iframe>
											<img src="img/poster.png" alt="">
										</div>
									</div>
									<div class="col-md-6 align-self-center">
										<a class="text-light" href="#"
										style="text-decoration:none;">
											<h3>${item.title}</h3>
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- detail -->
		
