<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
		<spring:url value="/market/products/admin/" var="saveProduct" />
	<form:form method="POST" modelAttribute="newProduct" action="${saveProduct}"
		class="form-inline" enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend><spring:message
						code="addProduct.form.productadmin.label" /></legend>
			<form:input type="hidden" id="id" path="id" class="form:input-large" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productName"><spring:message
						code="addProduct.form.productName.label" /></label>
				<div class="col-lg-10">
					<form:input id="productName" path="productName" type="text"
						class="form:input-large" />
					<form:errors path="productName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for=description><spring:message
						code="addProduct.form.description.label" /></label>
				<div class="col-lg-10">
					<form:input id="description" path="description" type="text"
						class="form:input-large" />
					<form:errors path="description" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="price"><spring:message
						code="addProduct.form.price.label" /></label>
				<div class="col-lg-10">
					<form:input id="price" path="price" type="text"
						class="form:input-large" />
						<form:errors path="price" cssClass="text-danger" />
				</div>
				
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productType"><spring:message
						code="addProduct.form.ProductType.label" /></label>
				<div class="col-lg-10">
					<form:select path="productType">
						<form:option value="" label="Choose Product type" />
						<form:options items="${types}" />
					</form:select>
					<form:errors path="productType" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />
				</div>
			</div>
		</fieldset>
	</form:form>
	</section> 
</br>
</br>
	<section class="container">
			<fieldset>
			<legend><spring:message
						code="addProduct.form.productlist.label" /></legend>
	<table class="table table-bordered">
			<thead>
				<tr>
					<th><spring:message
						code="addProduct.form.id.label" /></th>
					<th><spring:message
						code="addProduct.form.productName.label" /></th>
					<th><spring:message
						code="addProduct.form.description.label" /></th>
					<th><spring:message
						code="addProduct.form.price.label" /></th>
							<th><spring:message
						code="addProduct.form.ProductType.label" /></th>
													<th><spring:message
						code="addProduct.form.option.label" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.id}</td>
						<td>${product.productName}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.productType}</td>
						<td><spring:url value="/market/products/admin/${product.id}"
								var="updateProduct" /> <a type="button" class="btn btn-primary"
							href="${updateProduct}"><spring:message
						code="addProduct.form.update" /></a> <spring:url
								value="/market/products/admin/delete/${product.id}" var="deleteProduct" /> <a
							type="button" class="btn btn-warning" href="${deleteProduct}"><spring:message
						code="addProduct.form.delete" /></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
				</fieldset>
</section>
