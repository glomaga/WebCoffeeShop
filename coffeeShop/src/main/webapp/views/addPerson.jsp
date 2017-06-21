<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<spring:url value="/register/add" var="savePerson" />
	<form:form method="POST" modelAttribute="newPerson"
		action="${savePerson}" class="form-horizontal"
		enctype="multipart/form-data" onsubmit="if(checkemail==-1) return false; return true" id ="formId">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<spring:message code="addPerson.form.personadmin.label" />
			</legend>
			<form:input type="hidden" id="person.id" path="person.id" class="form:input-large" />
			<form:input type="hidden" id="person.enable" path="person.enable" class="form:input-large" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.firstName"><spring:message
						code="addPerson.form.firstName.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.firstName" path="person.firstName" type="text"
						class="form:input-large" required="required" />
					<form:errors path="person.firstName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg		<-2 col-lg-2" for=person.lastName><spring:message
						code="addPerson.form.lastName.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.lastName" path="person.lastName" type="text"
						class="form:input-large" required="required"/>
					<form:errors path="person.lastName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="email"><spring:message
						code="addPerson.form.email.label" /></label>
				<div class="col-lg-10">
					<form:input id="email" path="person.email" type="text"
						class="form:input-large" required="required" />
					<span id="user_name_check"></span>
					<form:errors path="person.email" cssClass="text-danger" />
				</div>

			</div>
						<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="user.password"><spring:message
						code="addPerson.form.password.label" /></label>
				<div class="col-lg-10">
					<form:input id="user.password" path="user.password" type="password"
						class="form:input-large" required="required" />
					<form:errors path="user.password" cssClass="text-danger" />
				</div>

			</div>

			<form:input type="hidden" id="addressid" path="person.address.id"
				class="form:input-large" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.address.city"><spring:message
						code="addPerson.form.address.city.label" /></label>
				<div class="col-lg-10">
					<form:input id="address.city" path="person.address.city" type="text"
						class="form:input-large" required="required"/>
					<form:errors path="person.address.city" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.address.state"><spring:message
						code="addPerson.form.address.state.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.address.state" path="person.address.state" type="text"
						class="form:input-large" required="required"/>
						<form:errors path="person.address.state" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.address.country"><spring:message
						code="addPerson.form.address.country.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.address.country" path="person.address.country" type="text"
						class="form:input-large" required="required"/>
						<form:errors path="person.address.country" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.address.zipcode"><spring:message
						code="addPerson.form.address.zipcode.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.address.zipcode" path="person.address.zipcode" type="text"
						class="form:input-large" required="required"/>
						<form:errors path="person.address.zipcode" cssClass="text-danger" />
				</div>
			</div>




			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="person.phone"><spring:message
						code="addPerson.form.phone.label" /></label>
				<div class="col-lg-10">
					<form:input id="person.phone" path="person.phone" type="text"
						class="form:input-large" required="required"/>
					<form:errors path="person.phone" cssClass="text-danger" />
				</div>

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