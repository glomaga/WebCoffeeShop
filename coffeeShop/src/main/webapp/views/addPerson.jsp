<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<section class="container">
	<spring:url value="/register/add" var="savePerson" />
	<form:form method="POST" modelAttribute="newPerson"
		action="${savePerson}" class="form-horizontal"
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
				<label class="control-label col-lg-2 col-lg-2" for="phone"><spring:message
						code="addPerson.form.phone.label" /></label>
				<div class="col-lg-10">
					<input id="phone" path="${users.password}" type="text"
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