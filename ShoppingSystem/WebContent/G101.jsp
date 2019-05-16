<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    String Msg = (String)session.getAttribute("login");
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
<form action="LoginUser" method="POST">
	<h1>ログイン</h1>
	<%
	if(StringEscapeUtils.escapeHtml4(Msg)==null){
	%>
	<%}else{ %>
	<CENTER>
	<%= StringEscapeUtils.escapeHtml4(Msg) %>
	</CENTER>
<%} %>
	<input type="text" placeholder="ユーザID(メールアドレス)" name="id"><br>
	<input type="text" placeholder="パスワード" name="password"><br><br>
	<input type="submit" value="ログイン"><br><br>
  <a class="button" href="G102.jsp">新規会員登録はこちら</a>
</form>

<%@ include file="footer.jsp" %>
</body>
</html>