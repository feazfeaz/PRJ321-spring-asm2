<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Mobile</title>
<%@include file="../reuse.component/view/jsLib.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/reuse.component/css/login.css"/>
</head>

<body>
	<%@include file="../reuse.component/view/header.jsp"%>
	<form class="box" action="./login" method="post">
		<h1>login</h1>
		<input type="text" name="username" id="" placeholder="Username">
		<input type="password" name="password" id="" placeholder="Password">
		<h6 class="relogin">${requestScope.erro}</h6>
		<input type="submit" value="Logjn">
	</form>

</body>

</html>