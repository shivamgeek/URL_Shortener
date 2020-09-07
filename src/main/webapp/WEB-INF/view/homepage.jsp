<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<body>
<h2>URL_Shortener Homepage</h2>
</body>

<hr><br><br>
<h3>New User! Register below - </h3>
<a href="${pageContext.request.contextPath}/user/register">Register as new user</a>
<hr>
<br>
<h3>Exising User, Login - </h3>
<br>
<form action="login" method="post">
	Email - <input type="text" name="email"><br>
	Password - <input type="text" name="password"><br>
	<input type="submit" value="Login">
</form>

<span style="color:red;">${errMsg}</span>

</html>
