<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/style.css " />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/add-customer-style.css " />
</head>
<body>

	<div id="wrapper">

		<div id="header">


			<h3>Save Customer:</h3>
			<form:form action="saveCustomer" method="POST"
				modelAttribute="customer">
				
				<form:hidden path="id"/>

				<table>
					<tbody>
						<tr>
							<td><label>FirstName:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>

						<tr>
							<td><label>LastName:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>


						<tr>

							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>


						<tr>
							<td></td>
							<td><input type="submit" value="Save" class="add-button" /></td>
						</tr>
					</tbody>

				</table>


			</form:form>

			<div style="clear;both;">
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">Back
						to List</a>
				</p>
			</div>

		</div>
	</div>
</body>
</html>