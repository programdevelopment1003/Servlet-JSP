<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean" import="model.PasswordBean" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    PasswordBean passbean  = (PasswordBean)session.getAttribute("passbean");
    UserBean user = (UserBean)session.getAttribute("user");
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
<form action="UserUpdate" method="POST">
	<h1>ユーザ情報変更</h1><br><br>
	<h2>ID:<%=StringEscapeUtils.escapeHtml4(user.getM_add()) %></h2>
	<br>
	<h2>氏名</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(user.getName())%>" name="name"><br><br>
	<h2>氏名(よみ)</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(user.getName_y())%>" name="name_y"><br><br>
	<h2>郵便番号</h2>
	<input type="text" value="<%=user.getP_code()%>" name="p_code"><br><br>
	<h2>住所</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(user.getS_add())%>" name="s_add"><br><br>
	<h2>電話番号</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(user.getT_code())%>" name="t_code"><br><br>
	
	<!-- <input type="text" placeholder="Authority" name="authority"><br> -->
	<input type="submit" value="OK"><br><br>
  <a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h)%>">キャンセル</a><br><br>
  <a class="button" href="PassUpdate">パスワード変更</a>
</form>
<CENTER>
<button class="button" id="but">退会</button>
</CENTER>

<script>
	//削除ボタンが押されたら
	document.getElementById('but').onclick = function() {
	var res = confirm("退会しますか？");
		if (res == true) {
		// OKなら移動
			window.location.href = "UserDelete";
		} else {
			// キャンセルならアラートボックスを表示
			alert("退会を取り消しました");
		}
	}
</script>

<%@ include file = "footer.jsp" %>
</body>
</html>