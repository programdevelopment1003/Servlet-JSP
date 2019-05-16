<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>しょうひんつい</title>
</head>
<body>
<form action="Addto" method="post">
商品名：<input type="text"name="name"><br>
説明：<input type="text"name="Descr"><br>
値段：<input type="text"name="price"><br>
区分：<input type="radio" name="Description" value="1">固形型
	<input type="radio" name="Description" value="2">砂型
	<input type="radio" name="Description" value="3">液体型<br>
	<input type="submit" value="登録">
</form>

</body>
</html>