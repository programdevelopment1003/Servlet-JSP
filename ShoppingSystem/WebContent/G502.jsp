<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BookBean" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    BookBean book  = (BookBean)session.getAttribute("upbook");
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
<form action="BookUpdate" method="POST">
	<h1>書籍情報変更</h1><br><br>
	<h2>ID:<%=book.getB_id() %></h2>
	<br>
	<h2>書籍名:<%=StringEscapeUtils.escapeHtml4(book.getB_name()) %></h2>
	<br>
	<h2>単価</h2>
	<input type="text" value="<%=book.getPrice()%>" name="price"><br><br>
	<h2>在庫数</h2>
	<input type="text" value="<%=book.getStock()%>" name="stock"><br><br>
	
	<input type="submit" value="更新"><br><br>
  <a class="button" href="BookAllOut">キャンセル</a>
</form>
<CENTER>
<button class="button" id="but">削除</button>
</CENTER>

<script>
	//削除ボタンが押されたら
	document.getElementById('but').onclick = function() {
	var res = confirm("削除しますか？");
		if (res == true) {
		// OKなら移動
			window.location.href = "BookDelete";
		} else {
			// キャンセルならアラートボックスを表示
			alert("削除を取り消しました");
		}
	}
</script>

<%@ include file = "footer.jsp" %>
</body>
</html>