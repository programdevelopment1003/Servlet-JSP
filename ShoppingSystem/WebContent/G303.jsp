<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GenreBean" import="model.UserBean" import="model.AuthorBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    int lastid = (int)session.getAttribute("g_lastid");
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
<form name="form" action="NewGenre" method="POST" >
	<h1>新規ジャンル登録</h1><br><br>
	<h2>ジャンルID：<%=lastid %></h2><br>
	ジャンル名：<input type="text" placeholder="" name="g_name"><br>
	
	<input type="submit" value="登録"><br><br>
  <a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">キャンセル</a>
</form>

<%@ include file = "footer.jsp" %>
<%} %>
</body>

</html>