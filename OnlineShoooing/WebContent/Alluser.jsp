<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.text.*"%>
<%@page import="model.UserBean" %>
<% ArrayList<UserBean> id=new ArrayList<UserBean>();
	 id = (ArrayList<UserBean>)session.getAttribute("user"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for(UserBean i:id){ %>
<%=i.getMail() %>
<%=i.getUsername() %>
<%=i.getName() %>
<%=i.getAddress() %>
<%=i.getPost() %>
<%} %>

</body>
</html>