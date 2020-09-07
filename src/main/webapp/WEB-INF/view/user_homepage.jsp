<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><br>
<title>User Homepage</title>

<style>
	.myError {color:red}
</style>

</head>
<body>
<h4>Welcome ${userData.firstName} ${userData.lastName} </h4>
<div style="text-align:right" >
<a href="${pageContext.request.contextPath}/user/goHome">Logout</a>
</div>
<hr>
<br>

<form action="${pageContext.request.contextPath}/user/createShortUrl/${userData.id}" method="get">
	Enter Original URL below <br> <input type="text" name="fullUrl" />
	<input type="submit" value="Generate URL">
</form>
<br>
(Note- Enter URL without "https://" and with "www". Example - www.xyz.com)

<br><br>

<c:if test="${!empty urlData}">
	<h5> Your generated shortened URL for ${urlData.fullUrl} is
	 <a href="${pageContext.request.contextPath}/url/${urlData.shortUrl}">
		${urlData.shortUrl}
	</a> 
	</h5>
</c:if>

<hr><br><br>

<h4>Want to see your previous URLs ? Click below </h4>
<form action="${pageContext.request.contextPath}/user/showUrlList/${userData.id}" method="get">
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
			<td>  S.no.  </td>
			<td>  Full URL  </td>
			<td>  Shortened URL </td>
			<td>  Action </td>
			</tr>
			<c:forEach items="${urlListData}" var="url">
				<tr>
					<td>${url.id} </td>
					<td>${url.fullUrl} </td>
					<td><a href="${pageContext.request.contextPath}/url/${url.shortUrl}">${url.shortUrl}</a></td>
					<td>
					<!--  CREATE DELETE LINK -->
					<c:url var="deleteUrl" value="/user/deleteURL/${userData.id}/${url.id}"> </c:url>
					
					<a href="${deleteUrl} "
					onClick="if(!(confirm('Are you sure, you want to delete this customer ?') )) return false" >
						Delete
					</a>
					<%-- <form action="deleteURL/${url.id}" method="post">
						<input type="submit" value="Delete">
					</form> --%>
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:when>
	</c:choose>
</c:if>

</body>
</html>