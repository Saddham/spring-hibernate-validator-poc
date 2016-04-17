<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Form Validation with Spring 3 MVC and Hibernate Validation</title>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	</head>
	<body>
		<h1>Registration Form</h1><br />
		<form:form action="updateEmployee" commandName="Employee">
		<table>
			<tr><td colspan="2"><form:errors path="*" cssStyle="color : red;"/></td></tr>
			<tr><td>Employee Id : </td><td><form:input path="id" /></td></tr>
			<tr><td>Name : </td><td><form:input path="fullName" /></td></tr>
			<tr><td>Age : </td><td><form:input path="age" /></td></tr>
			<tr><td>Email : </td><td><form:input path="emailID" /></td></tr>
			<tr><td>Experience : </td><td><form:input path="experience" /></td></tr>
			<tr><td>Start Date : </td><td><form:input path="startDate" /></td></tr>
			<tr><td>End Date : </td><td><form:input path="endDate" /></td></tr>
			<tr><td colspan="2"><input type="submit" value="Update" /></td></tr>
		</table>
		</form:form>
	</body>
</html>