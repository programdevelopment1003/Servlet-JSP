<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String getname=(String)session.getAttribute("number");
		 System.out.println(getname);
%>
<%int human = Integer.parseInt(getname); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細登録</title>
</head>
<body>
<form action="G206" method="post"enctype="multipart/form-data" >
<table border="0">
<%for(int i =0;i<human;i++){

	String s = String.valueOf(i);
	String name ="name"+s;
	String img="img"+s;
	String De="De"+s;%>
	<tr>
			<td>コンテンツ名</td>
			<td><input type="text" name=<%=name%> size="30" /></td>
			</tr>
			<tr>
			<td>画像</td>
			<td><input type="file" name=<%=img %> size="30"/></td>
			</tr>
			<tr>
			<td>説明</td>
			<td><input type="text" name=<%=De %> size="30"/></td>
			</tr>
			<%} %>
			<tr>
			<td colspan="2">
         		<input type="submit" value="登録"></td>
			</tr>
			</table>
			</form>

</body>

</html>