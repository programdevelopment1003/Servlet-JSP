<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body>
	メールアドレス：<input type="text"id="mail"><br>
	パスワード：<input type="password" id="pass"><br>
	確認用パスワード<input type="password" id="againpass"><br>
	ユーザー名<input type="text" id="username"><br>
--------------------本人情報-----------------------------<br>
	名前:<input type="text"id="name"><br>
	郵便番号:<input type="text"id="post"><br>
	住所:<input type="text"id="address"><br>
		<input type="button" value="登録" onclick="dispText()">


<input style=border:none type="password" id="md5Text" size="0" readonly="readonly">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/MD5.js"></script>
<script >

function dispText(){
	var mail=document.getElementById("mail").value;
	var pass=document.getElementById("pass").value;
	var againpass=document.getElementById("againpass").value;
	var username=document.getElementById("username").value;
	var name=document.getElementById("name").value;
	var post=document.getElementById("post").value;
	var address=document.getElementById("address").value;
	var passlength=pass.length;
	if(mail==null || pass==null ||  againpass==null || username==null || name==null || post==null || address==null){
		alert("入力されてない項目があります");
	}else if(passlength<4){
		alert("パスワードは４文字以上に必要です");
	}else if(pass!=againpass){
		alert("パスワードと確認用パスワードが違います");
	}else{
	var orig = document.getElementById("pass");
	  var md5Text = document.getElementById("md5Text");

	  md5Text.value = CybozuLabs.MD5.calc(orig.value);

	  var form = document.createElement('form');

		form.method='POST';

		form.action ='Register';

		var reqElm0 =document.createElement('input');
		var reqElm1 =document.createElement('input');
		var reqElm3 =document.createElement('input');
		var reqElm4 =document.createElement('input');
		var reqElm5 =document.createElement('input');
		var reqElm6 =document.createElement('input');


		reqElm0.name='mail';
		reqElm0.value=mail;
		reqElm1.name='pass';
		reqElm1.value=md5Text.value;
		reqElm3.name='username';
		reqElm3.value=username;
		reqElm4.name='name';
		reqElm4.value=name;
		reqElm5.name='post';
		reqElm5.value=post;
		reqElm6.name='address';
		reqElm6.value=address;

		form.appendChild(reqElm0);
		form.appendChild(reqElm1);
		form.appendChild(reqElm3);
		form.appendChild(reqElm4);
		form.appendChild(reqElm5);
		form.appendChild(reqElm6);

		document.body.appendChild(form)

		form.submit();
	}


}
</script>
</body>
</html>