<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.UserBean" %>
<%UserBean id = (UserBean)session.getAttribute("change"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>変更</title>
</head>
<body>
<form action="Tochange" method="post">
<input type="text"name="username"value="<%=id.getUsername() %>"><br>
<input type="text"name="mail"value="<%=id.getMail() %>"><br>
<input type="text"name="name"value="<%=id.getName()%>"><br>
<input type="text"name="post"value="<%=id.getPost() %>"><br>
<input type="text"name="address"value="<%=id.getAddress() %>"><br>
<input type="submit" value="変更"onclick="dispText()">
</form>
<a  href="Passchange.jsp"></a>

<script >

function dispText(){
	alert("本当に変更してよろしいですか？");
}
</script>

</body>
</html>