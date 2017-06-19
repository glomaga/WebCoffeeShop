<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-2">
					<div class="thumbnail">
						<div class="caption">
							<h4>${product.productName}</h4>
							<p>${product.description}</p>
							<p>$${product.price}</p>
							<p>${product.productType}</p>
							<p>
								<a
									href=" <spring:url value="/market/product?id=${product.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> <spring:message
						code="list.details" />
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
