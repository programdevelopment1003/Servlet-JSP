

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>画像のアップロード</h1>
	<form action="bole" method="post"enctype="multipart/form-data" >
	<table border="0">
		<tr>

			<td>コンテンツ名:</td>
			<td><input type="text" name="name" size="30" /></td>
         </tr>
         <tr>
         	<td>画像：</td>
         		<td><input type="file" name="file" size="30"caoture="camera" /></td>
         </tr>

         <tr>
         	<td>詳細に登録する画像</td>
         		<td>
         <tr>
         	<td colspan="2">
         		<input type="submit" value="登録">
         	</td>
         </tr>
      </table>
      </form>
</body>
</html>