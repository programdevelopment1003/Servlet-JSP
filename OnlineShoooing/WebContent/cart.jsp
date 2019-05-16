<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.CartBean" %>
 <%@ page import="java.io.*,java.util.*,java.text.*"%>
	<%
	ArrayList<CartBean> id=new ArrayList<CartBean>();
	 id = (ArrayList<CartBean>)session.getAttribute("cart"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%for(CartBean i:id){%>
<%=i.getName()%>
<%=i.getProdu()%>
<%=i.getPtopn()%>
<%=i.getPtopn()%>
 <% }%>


</body>
</html>