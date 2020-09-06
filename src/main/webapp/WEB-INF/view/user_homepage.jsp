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
<div style="text-align:right" >
<a href="${pageContext.request.contextPath}/user/goHome">Logout</a>
</div>
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

<h4>Want to see your previous URLs ? Click below </h4>
<form action="showUrlList" method="get">
	<input type="hidden" name="userID" value="${userData.id}">
	<input type="submit" value="Show me list of URLS">
</form>

<c:if test="${!empty urlListData}">
	<c:choose>
		<c:when test="${urlListData.size() <= 0 }">
			<h5> Nothing to show yet!</h5>
		</c:when>
		<c:when test="${urlListData.size() > 0 }">
		<h5> Your List of URLS are - </h5>
		<table>
			<tr>
			<td>S.no.</td>
			<td>Full URL</td>
			<td>Shortened URL</td>
			</tr>
			<c:forEach items="${urlListData}" var="url">
				<tr>
					<td>${url.id} </td>
					<td>${url.fullUrl} </td>
					<td>${url.shortUrl} </td>
				</tr>
			</c:forEach>
		</table>
		</c:when>
	</c:choose>
</c:if>

</body>
</html>