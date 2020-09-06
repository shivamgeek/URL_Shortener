<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	Enter Original URL here - <input type="text" name="fullUrl" />
	<input type="hidden" name="userID" value="${userData.id}">
	<input type="submit" value="Generate URL">
</form>

<br><br>

<c:if test="${!empty urlData}">
	<h5> Your generated shortened URL for ${urlData.fullUrl} is ${urlData.shortUrl} </h5>
</c:if>

<hr><br><br>

</body>
</html>