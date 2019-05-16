<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BookBean" import="model.UserBean" import="model.CartBean" import="model.GenreBean" import="model.AuthorBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
    arraybook = (ArrayList<BookBean>)session.getAttribute("arraybook");
    CartBean cart = new CartBean();
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
<br><br>
<h2>商品一覧</h2>

<table class="table table-bordered">
<tr><td>キーワード検索</td>
<td>ジャンル検索</td>
<td>著者検索</td>
</tr>
<tr><td><form action="BookSearch" method="POST">
	<input type="text" placeholder="キーワードを入力(ひらがな)" name="books"><br>
	<input type="submit" value="検索"><br><br>
</form></td>
<td><form method="get" action="BookSearchSelect">

<p>
<select name="genre" required>
<option value="">選択してください</option>
<%for(GenreBean genre:arraygenre){ %>
	<option value="<%= genre.getG_id()%>"><%= StringEscapeUtils.escapeHtml4(genre.getG_name()) %></option>
<%} %>

</select>
</p>

<p><input type="submit" value="検索する"></p>
</form></td>
<td><form method="post" action="BookSearchSelect"><p>
<select name="author" required>
<option value="">選択してください</option>
<%for(AuthorBean author:arrayauthor){ %>
	<option value="<%= author.getA_id()%>"><%= StringEscapeUtils.escapeHtml4(author.getA_name()) %></option>
<%} %>

</select>
</p>

<p><input type="submit" value="検索する"></p>
</form></td>
</tr>
</table>

<table class="table table-bordered">
<tr><td>書籍ID</td>
<td>書籍名</td>
<td>書籍名(よみ)</td>
<td>単価</td>
<td>著者ID</td>
<td>ジャンルID</td>
<td>在庫</td>
<td>画像</td>
<td>カート</td>

<%for(BookBean book:arraybook){ %>
<tr><td><a href="BookUpdate?id=<%=book.getB_id()%>"><%=book.getB_id()%></a></td>
	<td><%= StringEscapeUtils.escapeHtml4(book.getB_name()) %></td>
	<td><%= StringEscapeUtils.escapeHtml4(book.getB_namey()) %></td>
	<td><%= book.getPrice() %></td>
	<td><%= book.getA_id() %></td>
	<td><%= book.getG_id() %></td>
	<td><%= book.getStock() %></td>
	<td><img style="width:55%;" src="GetPicture?id=<%= book.getB_id() %>" class="pict"></td>
	<%if(book.getStock()>0){ %>
	<td><a href="CartInsert?id=<%=book.getB_id()%>">カートに追加</a></td>
	<%}else{ %>
	<td>購入不可</td>
	<%} %>
	</tr>
<%} %>
</table>
<br>
<CENTER>
<a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">トップへ戻る</a>
</CENTER>


<%@ include file = "footer.jsp" %>
<%} %>
</body>
</html>