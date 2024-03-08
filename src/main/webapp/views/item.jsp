<!-- list item -->
<div class="container bg-body-secondary">
    <div class="row">
        <c:forEach var="item" items="${lstVideo}">
        	<div class="col-md-4 my-2">
	            <div class="card" style="width: 22rem;">
	            	<a href="<c:url value='/video?action=watch&id=${item.href}'/>">
	            		<img src="https://img.youtube.com/vi/${item.href}/maxresdefault.jpg"
	            		class="card-img-top">
	            	</a>
	                <div class="card-body"> 
	                  <h5 class="card-title bg-body-secondary p-2">${item.title}</h5>
	                  <div class="d-flex justify-content-md-end">
	                   <button class="btn btn-secondary me-2">LIKE</button>
	                   <button class="btn btn-secondary">SHARE</button>
	                  </div>
	                </div>
	            </div>
	        </div>
        </c:forEach>
        <!-- pagination -->
        <div class="row justify-content-md-center py-3">
            <div class="col-md-1">
            	<c:if test="${currentPage == 1}">
            		<button class="btn btn-secondary disabled">
            			<a href="" class="text-light"
            			 style="text-decoration:none;"><</a>
            		</button>
            	</c:if>
            	<c:if test="${currentPage > 1}">
            		<button class="btn btn-secondary">
            			<a href="index?page=${currentPage - 1}" class="text-light"
            			style="text-decoration:none;"><</a>
            		</button>
            	</c:if>
            </div>
            <c:forEach varStatus="i" begin="1" end="${maxPage}">
            	<div class="col-md-1">
	                <button class="btn btn-secondary">
	                	<a href="index?page=${i.index}"
	                	class="text-light ${currentPage == i.index ? 'active' : ''}"
	                	style="text-decoration:none;">${i.index}</a>
	                </button>
	            </div>
            </c:forEach>
            <div class="col-md-1">
                <c:if test="${currentPage == maxPage}">
            		<button class="btn btn-secondary disabled">
            			<a href="" class="text-light" 
            			style="text-decoration:none;">></a>
            		</button>
            	</c:if>
            	<c:if test="${currentPage < maxPage}">
            		<button class="btn btn-secondary">
            			<a href="index?page=${currentPage + 1}" class="text-light"
            			style="text-decoration:none;">></a>
            		</button>
            	</c:if>
            </div>
        </div>
        <!-- pagination -->
    </div>
</div>
<!-- list item -->