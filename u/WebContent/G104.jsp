<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "dto.UserDto" %>
<%@ page import = "dto.LoginDto" %>

<!DOCTYPE html>
<html id="update">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>ユーザ</title>
<link href="css/userup.css" rel="stylesheet" type="text/css">
</head>
<body>

  <%
  //セッションからデータを取得する
	LoginDto logindto = (LoginDto)session.getAttribute("logindto");%>

  <h1>登録内容</h1><h3>変更・退会</h3>
  <form action="UpdateinputUser" method="POST" name="form2">
  <table>
    <tr>
      <th>メールアドレス</th>
      <td><input type=text name=mail placeholder="<%=logindto.getMail() %>" size=28 style="font-size:20px;"></td>
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
      <td><input type=text name=name placeholder="<%=logindto.getName() %>" size=28 style="font-size:20px;"></td>
    </tr>
  </table>

  <input class="share_btn2 shtw" type="submit" value="変更"><br>
  <input class="share_btn2 shfb" type="button" value="退会" onClick="disp()"><br>


<script type="text/javascript">
function disp(){
	// 「OK」時の処理開始 ＋ 確認ダイアログの表示
	if(window.confirm('本当にいいんですね？')){
		location.href = "UpdateinputUser"; // example_confirm.html へジャンプ
	}
	// 「OK」時の処理終了
	// 「キャンセル」時の処理開始
	else{
		window.alert('キャンセルされました'); // 警告ダイアログを表示
	}
	// 「キャンセル」時の処理終了
}

function checkForm(){
    if(document.form2.mail.value == "" || document.form2.pass.value == ""
    		|| document.form2.pass2.value == "" || document.form2.name.value == ""){
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
