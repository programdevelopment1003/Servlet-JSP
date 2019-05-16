<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String error = null;
	error =  (String)request.getAttribute("error");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>コンテンツの追加</h1>
	<form action="G205" method="post"enctype="multipart/form-data" >
		<table border="0">
		<tr>

			<td>コンテンツ名</td>
			<td><input type="text" name="name" size="30" /></td>
			</tr>
			<tr>
			<td>画像</td>
			<td><input type="file" name="img" size="30"/></td>
			</tr>
			<tr>
			<td>説明</td>
			<td><input type="text" name="Description" size="30"/></td>
			</tr>
			<tr>
			<%if(error != null){ %>

			<td><%= error %></td>

			<%} %>
			<td>開催日～終了日</td>
			<td><input type="text" name="start" size="30"/>～<input type="text" name="end" size="30"/>
			</tr>
			<tr>
			<td>登録する画像数</td>
			<td>
			<input type="text" name="number" size="30"/></td>
			<td colspan="2">
         		<input type="submit" value="登録"></td>
			</tr>
			</table>
			</form>

</body>
</html>