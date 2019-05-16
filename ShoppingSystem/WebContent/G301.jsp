<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GenreBean" import="model.UserBean" import="model.AuthorBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    String Msg1 = (String)session.getAttribute("msg2");
    String Msg2 = (String)session.getAttribute("msg3");
    int lastid = (int)session.getAttribute("lastid");
    UserBean user = (UserBean)session.getAttribute("user");
    
    ArrayList<GenreBean> arraygenre = new ArrayList<GenreBean>();
    arraygenre = (ArrayList<GenreBean>)session.getAttribute("arraygenre");
    
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

<form name="form" action="NewBook" method="POST" enctype="multipart/form-data">
	<h1>新規商品登録</h1><br><br>
	<h2>商品ID：<%=lastid %></h2><br>
	商品名：<input type="text" placeholder="" name="book"><br>
	商品名(よみ)：<input type="text" placeholder="" name="booky"><br>
	単価：<input type="text" placeholder="" name="price"><br>
	<p>
	ジャンル：<select name="genre" required>
	<option value="">選択してください</option>
	<%for(GenreBean genre:arraygenre){ %>
	<option value="<%= genre.getG_id()%>"><%= StringEscapeUtils.escapeHtml4(genre.getG_name()) %></option>
	<%} %>
	</select></p><br>
	<p>
	著者：<select name="author" required>
	<option value="">選択してください</option>
	<%for(AuthorBean author:arrayauthor){ %>
	<option value="<%= author.getA_id()%>"><%= StringEscapeUtils.escapeHtml4(author.getA_name()) %></option>
	<%} %>
	</select></p><br>
	在庫数：<input type="text" placeholder="" name="stock"><br>
	商品画像：<input type="file" placeholder="" name="picture"><br>
	
	<input type="submit" value="登録"><br><br>
  <a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">キャンセル</a>
</form>

<%@ include file = "footer.jsp" %>
<%} %>
</body>

</html>