<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<li><a href="<spring:url value="/market/products"/>">
<spring:message code="navigation.home" /></a></li>
<li><a href="<spring:url value="/market/products/admin"/>">
<spring:message code="navigation.adminproduct" /></a></li>
<li><a href="<spring:url value="/market/person/admin"/>">
<spring:message code="navigation.adminperson" /></a></li>
<li><a href="<spring:url value="/market/order/admin"/>">
<spring:message code="navigation.adminorder" /></a></li>
<li><a href="<spring:url value="/market/cart/"/>">
<spring:message code="navigation.cart" /></a></li>
