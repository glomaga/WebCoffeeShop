<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<fieldset>
		<legend>
			<spring:message code="order.form.list.label" />
		</legend>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><spring:message code="order.form.id.label" /></th>
					<th><spring:message code="order.form.orderDate.label" /></th>
					<th><spring:message code="order.form.person.label" /></th>
					<th><spring:message code="order.form.orderLines.label" /></th>
					<th><spring:message code="order.form.option.label" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.orderDate}</td>
						<td>${order.person.email}</td>
						<td>${order.orderLines.size()}</td>
						<td><spring:url
								value="/market/order/admin/delete/${order.id}" var="deleteOrder" />
							<a type="button" class="btn btn-warning" href="${deleteOrder}"><spring:message
									code="order.form.delete" /></a>
					
					
					<spring:url
								value="/market/order/admin/line/${order.id}" var="OrderDetails" />
							<a type="button" class="btn btn-primary" href="${OrderDetails}">
							<spring:message
									code="order.form.OrderDetails" /></a>
					</td>
									
									
									
									
									
									
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</fieldset>
</section>
