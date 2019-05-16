<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GenreBean" import="model.UserBean" import="model.AuthorBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    ArrayList<GenreBean> arraygenre = new ArrayList<GenreBean>();
    arraygenre = (ArrayList<GenreBean>)session.getAttribute("arraygenre");
    UserBean user = (UserBean)session.getAttribute("user");
    
    ArrayList<AuthorBean> arrayauthor = new ArrayList<AuthorBean>();
    arrayauthor = (ArrayList<AuthorBean>)session.getAttribute("arrayauthor");
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
<%if(StringEscapeUtils.escapeHtml4(user.getAuthority())==null){%>
	<meta http-equiv="refresh"content="1; url=LoginUser">
<%}else{	%>
<br><br>
<h2>メニュー</h2>
<table class="table table-bordered">
<tr>
<td><a class="button" href="BookAllOut">商品一覧</a></td>
<td><a class="button" href="GetOrder">注文履歴</a></td>
</tr>
</table><br><br>
<h2>管理者機能</h2>
<table class="table table-bordered">
<tr>
<td><a class="button" href="NewBook">新規商品追加</a></td>
<td><a class="button" href="NewAuthor">新規著者追加</a></td>
<td><a class="button" href="NewGenre">新規ジャンル追加</a></td>
<td><a class="button" href="UserAllOut">全会員情報確認</a></td>
</tr>
</table>

<%@ include file = "footer.jsp" %>
<%} %>
</body>
</html>