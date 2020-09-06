<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><br>
<title>User Homepage</title>
</head>
<body>
<h4>Welcome ${userData.firstName} ${userData.lastName} </h4>
<hr>
<br>

<form action="createShortUrl" method="get">
	<input type="text" name="originalURL">
	<input type="submit" value="Generate URL">
</form>

<br><br>

<h5>Your Generated URL will come here - ${shortenedURL}</h5>

<hr><br><br>

</body>
</html>