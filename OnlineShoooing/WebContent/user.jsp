<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.*" %>
<%@page import="model.UserBean" %>
<%UserBean id = (UserBean)session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%=id.getUsername() %>
<%=id.getMail() %>
<%=id.getName() %>
<%=id.getPost() %>
<%=id.getAddress() %>

<a href="Change">会員情報変更</a>
<a href="Delete">会員情報削除</a>
</head>
<body>
<script type="text/javascript">
function dispText(){
if(window.confirm('本当に削除してもよろしいですか')){
	location.href="Erasing";
}
}
</script>
</body>
</html>