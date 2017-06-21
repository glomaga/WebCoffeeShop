<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section class="container" ng-app="cartApp">
	<div class="row">
		<div class="col-md-5">
			<h3>${product.productName}</h3>
			<p>${product.description}</p>
			<p>
				<strong><spring:message code="addProduct.form.id.label" />
				</strong><span class="label label-warning">${product.id}</span>
			</p>
			<p>
				<strong><spring:message
						code="addProduct.form.productName.label" /></strong> :
				${product.productName}
			</p>
			<p>
				<strong><spring:message
						code="addProduct.form.description.label" /></strong> :
				${product.description}
			</p>
			<p>
				<strong><spring:message
						code="addProduct.form.ProductType.label" /></strong> :
				${product.productType}
			</p>
			<h4>${product.price}USD</h4>
<%-- 	<sec:authorize access="isAnonymous()"> --%>
<%--     <form method="POST" action="<c:url value='j_spring_security_check'/>"> --%>
<%--         Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" />  --%>
<!--         Password: <input name="j_password" type="password" />  -->
<!--         <input type="submit" value="Sign in" /> -->
<!--     </form> -->
<%-- </sec:authorize> --%>
<%-- 	<sec:authorize access="isAuthenticated()"> --%>
<%--     <a href="<c:url value="/j_spring_security_logout" />">Logout</a> --%>
<%-- </sec:authorize> --%>
    
    
    
			<p ng-controller="cartCtrl">
				<a href="<spring:url value="/market/products" />"
					class="btn btn-default"> <span
					class="glyphicon-hand-left glyphicon"></span> <spring:message
						code="product.back" />
				</a> 
				<sec:authorize access="hasRole('ROLE_USER') ">
				<a href="#" class="btn btn-warning btn-large"
					ng-click="addToCart('${product.id}')"> <span
					class="glyphicon-shopping-cart glyphicon"></span> <spring:message
						code="product.OrderNow" />
				</a> <a href="<spring:url value="/market/cart" />" class="btn btn-default">
					<span class="glyphicon-hand-right glyphicon"></span> <spring:message
						code="product.ViewCart" />
				</a>
				</sec:authorize>
			</p>
		</div>
	</div>
</section>
