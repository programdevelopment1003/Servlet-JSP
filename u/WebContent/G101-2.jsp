<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id=login2>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>投票</title>
<link href="css/test.css" rel="stylesheet" type="text/css">
</head>
<body>
  <article>

  <div class="sample6Wrap">
  	<div class="sample6">
      <h1>Login</h1>
      <form action="LoginErrServlet" method="post">
      <table id=idpass>
        <tr>
          <th>ID</th>
          <td><input type="text" name="mail" size=28 style="font-size:20px;" placeholder="メール"></td>
        </tr>
        <tr>
          <th>password</th>
          <td><input type="text" name="pass" size=28 style="font-size:20px;"></td>
        </tr>
      </table>
      <h4>ID・パスワードが間違っています</h4>
      <input class="share_btn2 shtw" type="submit" value="ログイン"><br>
      <a class="share_btn2 shfb" href="G102.jspl">新規登録</a><br>
    </form>
    </div>
  </div>
</article>

</body>
</html>