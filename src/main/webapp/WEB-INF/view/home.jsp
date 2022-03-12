
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

<hr>
<!--Ad link to point to /leaders.. tis is for managers  -->
<a href="${pageContext.request.contextPath}/leaders ">LeaderShip Meeting</a>(Only for leaders)

</hr>

<hr>
<!--Ad link to point to /leaders.. tis is for managers  -->
<a href="${pageContext.request.contextPath}/systems ">IT Systems Meeting</a> (Only for Admin peeps)
</hr>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout">
</form:form> 
</body>

</html>