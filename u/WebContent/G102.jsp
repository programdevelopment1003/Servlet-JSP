<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "dto.UserDto" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>新規会員登録</title>
<link href="css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
  <h1>新規登録</h1>
  <form action="InputServlet" method="POST" name="form1">

  <table>
    <tr>
      <th>メールアドレス</th>
      <td><input type=text name=mail placeholder="aaaaa@gmail.com" size=28 style="font-size:20px;"></td>
    </tr>
    <tr>
      <th>パスワード</th>
      <td><input type=password name=pass placeholder="英数8文字以上" size=28 style="font-size:20px;"></td>
    </tr>
    <tr>
      <th>再・パスワード</th>
      <td><input type=password name=pass2 placeholder="再度 同じパスワード入力" size=28 style="font-size:20px;"></td>
    </tr>
    <tr>
      <th>ニックネーム</th>
      <td><input type=text name=name placeholder="うみちゃん" size=28 style="font-size:20px;"></td>
    </tr>
  </table>

  <p><a class="share_btn2 shfb" href="101.jsp">キャンセル</a>
  <input class="share_btn2 shtw" type="submit" value="確認へ" onClick="return checkForm();"></p>
  <br>
</form>

<script>
function checkForm(){
    if(document.form1.mail.value == "" || document.form1.pass.value == ""
    		|| document.form1.pass2.value == "" || document.form1.name.value == ""){
        alert("全項目を入力して下さい。");
	return false;
    }else{
    	if (form1.pass.value != form1.pass2.value){
    		alert("パスワードが一致していません。再度入力して下さい。");
    		return false;
    	}else{
    		return true;
    	}
    }
}

</script>
</body>
</html>
