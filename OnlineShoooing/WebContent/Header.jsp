<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.InformationBean" %>
	<%InformationBean id = (InformationBean)session.getAttribute("informationBean"); %>
	<%String ok =null;
	ok=(String)session.getAttribute("ok");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<header>
<h1>店の名前</h1>
<%if(id==null){%>
ネットショッピング｜<a href="Loin.jsp">ログイン</a>｜<a href="Signup.jsp">新規登録</a>
<%}else{ %>
ネットショッピング| <%=id.getUsername() %> |<a href="Loginout">ログアウト</a>|<a href="user">ユーザー情報</a>｜<a href="Getcart">カート情報</a>
<%}%>
<form action="Search" method="get">
<input type="text" name="Search" >
		 <input type="submit" value="検索">
		 </form>

</header>
</body>
</html>