<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
 <script src="/resources/js/controllers.js"></script> 
  <script src="/resources/js/register.js"></script> 

</head>

<body>
	<section class="container">
		<div class="pull-right" style="padding-right: 50px">
		<sec:authorize access="isAuthenticated()">
		<sec:authentication var="principal" property="principal" />
		<spring:message code="User" />: ${principal.username}
		<a href="/profile">Update Profile</a>
		</sec:authorize>	
			<a href="?language=en">English</a>|<a href="?language=es">Spanish</a> 
			<sec:authorize access="isAnonymous()">
 				<a href="<c:url value="/login" />">Login</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<sec:authentication var="principal" property="principal" />
   				<a href="<c:url value="/logout" />">Logout</a>
			</sec:authorize>	
		</div>
	</section>

	<div class="container">
		<div class="jumbotron">
			<div class="header">
				<ul class="nav nav-pills pull-right">
					<tiles:insertAttribute name="navigation" />
				</ul>
				<h3 class="text-muted"><spring:message
						code="title" /></h3>
			</div>

			<h2>
				<tiles:insertAttribute name="heading" />
			</h2>
			<h6>
				<tiles:insertAttribute name="tagline" />
			</h6>
		</div>

		<div class="row">
			<tiles:insertAttribute name="content" />
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
