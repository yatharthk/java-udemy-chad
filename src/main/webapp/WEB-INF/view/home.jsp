
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>
	Welcome to the luv2code company home page!
</p>
<hr>
<p>
User: <security:authentication property="principal.username"/>
Role(s): <security:authentication property="principal.authorities"/>

<security:authorize access="hasRole('MANAGER')">

<!--Ad link to point to /leaders.. this is for managers  -->
<a href="${pageContext.request.contextPath}/leaders ">LeaderShip Meeting</a>(Only for leaders)
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<!--Ad link to point to /systems.. tHis is for ADMIN  -->
<a href="${pageContext.request.contextPath}/systems ">IT Systems Meeting</a> (Only for Admin peeps)
</security:authorize>
<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout">
</form:form> 
</body>

</html>