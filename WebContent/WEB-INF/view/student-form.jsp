<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!Doctype html>

<html>

<head>
 <title>Student Registration Form</title>
</head>

<body>

<form:form action="processForm" modelAttribute="student">

FirstName: <form:input path="firstName"/>
<br>


LastName: <form:input path="lastName"/>

<br><br>

Country:
<form:select path="country">
	
	<form:options items="${student.countryOptions}"/>
	

</form:select>
<br><br>

Favorite Language:

<%-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
 --%>
 
 
 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
<br><br>

<br><br>
Operating Systems:

Linux<form:checkbox path="operatingSystems" value="Linux"/>
Mac<form:checkbox path="operatingSystems" value="Mac OS"/>
Windows<form:checkbox path="operatingSystems" value="MS WIndows OS"/>


<input value="submit" type="submit"/>



</form:form>


</body>

</html>