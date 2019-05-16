<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String name=(String)session.getAttribute("name"); %>
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>投票</title>
<link href="css/head.css" rel="stylesheet" type="text/css">
</head>
<body>

 <header id="header">
    <a href="Cont"><img src="画像ap/ホームt.png" width="100px"></a>
    <a class=logout href="Logout"><img src="画像ap/out.png" width=80px></a>
    <a class=logout href="G205.jsp"><img src="画像ap/追加.jpg" width="80px"></a>
    <ul>
      <li><a href="G104.html"><%=name %>さん</a></li>
    </ul>
  </header>


</body>
</html>
