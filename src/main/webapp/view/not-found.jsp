<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Noof Store - 404</title>
<%@include file="../reuse.component/view/jsLib.jsp"%>
</head>
<body>
	<%@include file="../reuse.component/view/header.jsp"%>
	<h1>404 - Page not found</h1>
	<br /> Đây là số lần người truy cập sai đường dẫn:
	<%=(Integer) getServletContext().getAttribute("count")%>
	<br /> Đây là số lần người truy cập sai đường dẫn:${applicationScope.count}
</body>
</html>