<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>

<style>
	.myError {color:red}
</style>

</head>
<body>

	<form:form action="saveCustomer" modelAttribute="userData" method="POST">
		<table>
			<tbody>
				<tr>
					<td>Enter First Name </td>
					<td><form:input path="firstName" /> <form:errors path="firstName" cssClass="myError" /> </td>
				</tr>
				<tr>
					<td>Enter Last Name </td>
					<td><form:input path="lastName" /><form:errors path="lastName" cssClass="myError" /></td>
				</tr>
				<tr>
					<td>Enter Email </td>
					<td><form:input path="email" /><form:errors path="email" cssClass="myError" /></td>
				</tr>
				<tr>
					<td>Enter Password </td>
					<td><form:input path="password" /><form:errors path="password" cssClass="myError" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit Data" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>

</body>
</html>