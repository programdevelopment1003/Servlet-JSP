<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    String path_h = (String)session.getAttribute("path");
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
<header>
    <h1><a href="<%=StringEscapeUtils.escapeHtml4(path_h)%>">BookShop</a></h1>
    
    <nav>
    <ul>
    <li><a  href="<%=path_h%>">トップページ</a></li>
    <li><a  href="GetCart">カート</a></li>
    <li><a  href="UserUpdate">会員情報管理</a></li>
    <li><a  href="LoginUser">ログアウト</a></li>

    </ul>
    </nav>
  </header>
</body>
</html>