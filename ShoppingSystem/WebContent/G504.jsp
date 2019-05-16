<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean" import="model.PasswordBean" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    PasswordBean passbean  = (PasswordBean)session.getAttribute("passbean");
    UserBean user = (UserBean)session.getAttribute("user");
    String passnot = (String)session.getAttribute("passnot");
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<form action="PassUpdate" method="POST">
	<h1>パスワード変更</h1><br><br>
	<h2>ID:<%=StringEscapeUtils.escapeHtml4(user.getM_add()) %></h2>
	<br>
	<%
	if(StringEscapeUtils.escapeHtml4(passnot)==null){
	%>
	<%}else{ %>
	<CENTER>
	<%= StringEscapeUtils.escapeHtml4(passnot) %>
	</CENTER><br>
	<%} %>
	<h2>現在のパスワード</h2>
	<input type="text" name="password"><br><br>
	<h2>変更後のパスワード</h2>
	<input type="text" placeholder="半角英数8字以上12字以内" name="newpass"><br><br>
	
	<input type="submit" value="OK"><br><br>
  <a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h)%>">キャンセル</a>
</form>

<%@ include file = "footer.jsp" %>
</body>
</html>