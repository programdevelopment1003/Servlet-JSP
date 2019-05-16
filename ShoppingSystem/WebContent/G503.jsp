<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean" import="model.PasswordBean" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    PasswordBean pass  = (PasswordBean)session.getAttribute("selectpass");
    UserBean user = (UserBean)session.getAttribute("selectuser");
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
<form action="UserUpdate2" method="POST">
	<h1>ユーザ情報変更</h1><br><br>
	<h2>ユーザID</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(user.getM_add()) %>" name="id"><br><br>
	<h2>パスワード</h2>
	<input type="text" value="<%=StringEscapeUtils.escapeHtml4(pass.getPassword())%>" name="password"><br><br>
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
	<h2>管理者権限(現在)：<%if(StringEscapeUtils.escapeHtml4(user.getAuthority())==null){ %>
	なし
	<%}else{ %>
	あり
	<%} %></h2>
	<p>*変更しない場合は、現在の状態を選択</p>
	<div class="radio">
	<label><input type="radio" name="authority" id="radio1" value="A"> あり</label>
	</div>
	<div class="radio">
	<label><input type="radio" name="authority" id="radio2" value=null> なし</label>
	</div>
	<input type="submit" value="OK"><br><br>
  <a class="button" href="UserAllOut">キャンセル</a>
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
			window.location.href = "UserDelete2";
		} else {
			// キャンセルならアラートボックスを表示
			alert("削除を取り消しました");
		}
	}
</script>

<%@ include file = "footer.jsp" %>
</body>
</html>