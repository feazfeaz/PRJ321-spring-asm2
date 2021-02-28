<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
à hà<br/>

<%@page import="utils.*" %>
<%
UserBean aha = (UserBean) request.getAttribute("ulti");
out.print(aha.getUsername());
out.print((new ClassForClear()).saySomething());
%>


</body>
</html>


<%--
<jsp:useBean id="um" class="utils.UserBean" scope="session"/>
<jsp:setProperty property="username" name="um" value="tenvahoday"/>
<%
int a = 1;
%>

<%=a%>
<%=um.getUsername() %>
 --%>