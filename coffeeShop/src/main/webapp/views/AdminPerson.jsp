<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<spring:url value="/market/person/admin/" var="savePerson" />
	<form:form method="POST" modelAttribute="newPerson"
		action="${savePerson}" class="form-inline"
		enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<spring:message code="addPerson.form.personadmin.label" />
			</legend>
			<form:input type="hidden" id="id" path="id" class="form:input-large" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message
						code="addPerson.form.firstName.label" /></label>
				<div class="col-lg-10">
					<form:input id="firstName" path="firstName" type="text"
						class="form:input-large" />
					<form:errors path="firstName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg		<-2 col-lg-2" for=lastName><spring:message
						code="addPerson.form.lastName.label" /></label>
				<div class="col-lg-10">
					<form:input id="lastName" path="lastName" type="text"
						class="form:input-large" />
					<form:errors path="lastName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="email"><spring:message
						code="addPerson.form.email.label" /></label>
				<div class="col-lg-10">
					<form:input id="email" path="email" type="text"
						class="form:input-large" />
					<form:errors path="email" cssClass="text-danger" />
				</div>

			</div>

			<form:input type="hidden" id="addressid" path="address.id"
				class="form:input-large" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="address.city"><spring:message
						code="addPerson.form.address.city.label" /></label>
				<div class="col-lg-10">
					<form:input id="address.city" path="address.city" type="text"
						class="form:input-large" />
					<form:errors path="address.city" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="address.state"><spring:message
						code="addPerson.form.address.state.label" /></label>
				<div class="col-lg-10">
					<form:input id="address.state" path="address.state" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="address.country"><spring:message
						code="addPerson.form.address.country.label" /></label>
				<div class="col-lg-10">
					<form:input id="address.country" path="address.country" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="address.zipcode"><spring:message
						code="addPerson.form.address.zipcode.label" /></label>
				<div class="col-lg-10">
					<form:input id="address.zipcode" path="address.zipcode" type="text"
						class="form:input-large" />
				</div>
			</div>




			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="phone"><spring:message
						code="addPerson.form.phone.label" /></label>
				<div class="col-lg-10">
					<form:input id="phone" path="phone" type="text"
						class="form:input-large" />
					<form:errors path="phone" cssClass="text-danger" />
				</div>

			</div>


			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="enable"><spring:message
						code="addPerson.form.enable.label" /></label>
				<div class="col-lg-10">
					<form:checkbox id="enable" path="enable" class="form:input-large" />
					<form:errors path="enable" cssClass="text-danger" />
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
		<legend>
			<spring:message code="addPerson.form.personlist.label" />
		</legend>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><spring:message code="addPerson.form.id.label" /></th>
					<th><spring:message code="addPerson.form.firstName.label" /></th>
					<th><spring:message code="addPerson.form.lastName.label" /></th>
					<th><spring:message code="addPerson.form.email.label" /></th>
					<th><spring:message code="addPerson.form.address.id.label" /></th>
					<th><spring:message code="addPerson.form.address.city.label" /></th>
					<th><spring:message code="addPerson.form.address.state.label" /></th>
					<th><spring:message
							code="addPerson.form.address.country.label" /></th>
					<th><spring:message
							code="addPerson.form.address.zipcode.label" /></th>
					<th><spring:message code="addPerson.form.phone.label" /></th>
					<th><spring:message code="addPerson.form.enable.label" /></th>
					<th><spring:message code="addPerson.form.option.label" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${people}" var="people">
					<tr>
						<td>${people.id}</td>
						<td>${people.firstName}</td>
						<td>${people.lastName}</td>
						<td>${people.email}</td>
						<td>${people.address.id}</td>
						<td>${people.address.city}</td>
						<td>${people.address.state}</td>
						<td>${people.address.country}</td>
						<td>${people.address.zipcode}</td>
						<td>${people.phone}</td>
						<td>${people.enable}</td>
						<td><spring:url value="/market/person/admin/${people.id}"
								var="updatePerson" /> <a type="button" class="btn btn-primary"
							href="${updatePerson}"><spring:message
						code="addPerson.form.update" /></a> <spring:url
								value="/market/person/admin/delete/${people.id}"
								var="deletePerson" /> <a type="button" class="btn btn-warning"
							href="${deletePerson}"><spring:message
						code="addPerson.form.delete" /></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</fieldset>
</section>
