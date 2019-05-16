<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dto.UserDto" %>
<%@ page import ="util.HtmlUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>新規会員登録</title>
<link href="css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%
  //セッションからデータを取得する
	UserDto userDto = (UserDto)session.getAttribute("userDto");%>

    <h1>新規登録</h1>
  <form action="RegisterUser" method="POST">
  <table>
    <tr>
      <th>メールアドレス</th>
      <td><%=HtmlUtil.sanitizing(userDto.getmail()) %></td>
    </tr>
    <tr>
      <th>パスワード</th>
      <td><%=HtmlUtil.sanitizing(userDto.getpass()) %></td>
    </tr>
    <tr>
      <th>ニックネーム</th>
      <td><%=HtmlUtil.sanitizing(userDto.getname()) %></td>
    </tr>
  </table>

  <h4>これで登録しますか？</h4>
  <a class="share_btn2 shbk" href="G102.jsp">戻る</a>
  <input class="share_btn2 shtw" type="submit" value="登　録">

</form>

</body>
</html>
