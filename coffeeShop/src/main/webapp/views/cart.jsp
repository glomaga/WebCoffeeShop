<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<section class="container" ng-app="cartApp">
	<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
		<div>
<%--<a href="<spring:url value="/checkout?cartId=${cartId}"/>" --%>
<!-- 				class="btn btn-success pull-right"> <span -->
<!-- 				class="glyphicon-shopping-cart glyphicon"></span> Check out -->
<!-- 			</a> -->
		</div>
	
	
	<section class="container">
	<fieldset>
	<legend>Info Order</legend>
	</fieldset>
	<div class="form-group">
	<label class="control-label col-lg-2 col-lg-2" for="id"><spring:message code="cart.form.orderid" />:</label>{{cart.id}}
	</div>
		<div class="form-group">
	<label class="control-label col-lg-2 col-lg-2" for="orderDate"><spring:message code="cart.form.orderdate" />:</label>{{cart.orderDate}}
	</div>
	<div class="form-group">
	<label class="control-label col-lg-2 col-lg-2" for="orderDate"><spring:message code="cart.form.email" />:</label>{{cart.person.email}}	
	</div>
</section> 
				<a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
				class="glyphicon glyphicon-remove-sign"></span> <spring:message code="cart.form.Clear" />
 			</a> 
		<table class="table table-hover">
			<tr>
				<th><spring:message code="cart.form.product" /></th>
				<th><spring:message code="cart.form.unitprice" /></th>
				<th><spring:message code="cart.form.Qantity" /></th>
				<th><spring:message code="cart.form.Action" /></th>
			</tr>
			<tr ng-repeat="item in cart.orderLines">
				<td>{{item.product.productid}}-{{item.product.productName}}</td>
				<td>{{item.product.price}}</td>
				<td>{{item.quantity}}</td>
				<td><a href="#" class="label label-danger"
					ng-click="removeFromCart(cart.id,item)"> <span
						class="glyphicon glyphicon-remove" /></span> <spring:message code="cart.form.Remove" />
				</a></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th> <spring:message code="cart.form.GrandTotal" /></th>
				<th>{{cart.totalAmount}}</th>
				<th></th>
			</tr>
		</table>

		<a href="<spring:url value="/market/products" />"
			class="btn btn-default"> <span
			class="glyphicon-hand-left glyphicon"></span> <spring:message code="cart.form.Continueshopping" />
		</a>
	</div>
</section>