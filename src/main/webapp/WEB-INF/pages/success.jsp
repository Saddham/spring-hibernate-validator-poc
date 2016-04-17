<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
</head>
<body>
	<h1>Registration has been completed with following details :</h1> <br>
	Employee Id:
	Name : ${Employee.fullName}.<br>
	Age : ${Employee.age}. <br>
	Email : ${Employee.emailID}.<br>
	Experience : ${Employee.experience}.<br>
	Start Date : ${Employee.startDate.get(2)}/${Employee.startDate.get(3)}/${Employee.startDate.get(1)}.<br>
	End Date : ${Employee.endDate.get(2)}/${Employee.endDate.get(3)}/${Employee.endDate.get(1)}.
</body>
</html>