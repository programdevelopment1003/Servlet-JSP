<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.*,java.util.*,java.text.*"%>
 <%@ page import="model.ProduBean" %>
	<%
	ArrayList<ProduBean> id=new ArrayList<ProduBean>();
	 id = (ArrayList<ProduBean>)session.getAttribute("Produ"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<%if(id==null){%>
商品がありません
<% }else{%>
<%for(ProduBean produ: id ){ %>
<h1><%=produ.getProductname() %></h1>
<%=produ.getCategoriesname() %>
<p><%=produ.getDescription() %></p>
<%=produ.getPrice() %>円

<form action="Cart" method="post">
<input style=border:none type="text"name="name"value="<%=produ.getProductname() %>"readonly="readonly"><br>
<input style=border:none type="text"name="ption"value="<%=produ.getCategoriesname() %>"readonly="readonly"><br>
<input style=border:none type="text" name="Product"value="<%=produ.getDescription()%>"readonly="readonly"><br>
<input style=border:none type="text" name="produ"value="<%=produ.getPrice() %>"readonly="readonly"><br>
<input style=border:none type="submit" value="変更"onclick="dispText()">
</form>
<% }%>
<%} %>


</body>
</html>