<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<fieldset>
		<legend>
			<spring:message code="orderline.form.list.label" />
		</legend>
		<a href="<spring:url value="/market/order/admin" />" class="btn btn-default"><span
					class="glyphicon-hand-left glyphicon"></span> 
					order back</a>

		<table class="table table-bordered">
			<thead>
				<tr>
				    <th><spring:message code="orderline.form.order.label" /></th>
					<th><spring:message code="orderline.form.id.label" /></th>
					<th><spring:message code="orderline.form.quantity.label" /></th>
					<th><spring:message code="orderline.form.product.label" /></th>
					<th><spring:message code="orderline.form.option.label" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${orderlines}" var="line">
					<tr>
						<td>${line.order.id}</td>
						<td>${line.id}</td>
						<td>${line.quantity}</td>
						<td>${line.product.productName}</td>
						<td>
							<%-- 						<spring:url value="/market/products/admin/${product.id}" --%>
							<%-- 								var="updateProduct" />  --%> <!-- 						<a type="button" class="btn btn-primary" -->
							<%-- 							href="${updateProduct}"><spring:message --%> <%-- 									code="addProduct.form.update" /></a>  --%>
							<spring:url value="/market/order/admin/line/delete/${line.order.id}/${line.id}"
								var="deleteLine" /> <a type="button" class="btn btn-warning"
							href="${deleteLine}"><spring:message
									code="order.form.delete" /></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</section>
