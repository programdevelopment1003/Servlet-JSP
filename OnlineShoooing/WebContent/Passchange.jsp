<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.UserBean" %>
<%UserBean id = (UserBean)session.getAttribute("change"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更</title>
</head>
<body>
<input type="password" id="pass"><br>
<input type="password" id="confirmationpass"><br>
<input type="button" value="変更" onclick="dispText()">


<input style=border:none type="password" id="md5Text" size="0" readonly="readonly">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/MD5.js"></script>
<script >
function dispText(){
	var pass=document.getElementById("pass").value;
	var confirmationpass=document.getElementById("confirmationpass").value;
	if(pass==null || confirmationpass==null){
		alert("入力されてない値があります。");
	}else if(pass != confirmationpass){
		alert("確認用パスワードとパスワードが違います。")
	}else if(pass<4){
		alert("パスワードは4文字以上です。")
	}
	var orig = document.getElementById("pass");
	  var md5Text = document.getElementById("md5Text");

	  md5Text.value = CybozuLabs.MD5.calc(orig.value);

		 var form = document.createElement('form');

			form.method='POST';

			form.action ='Passchange';

			var reqElm0 =document.createElement('input');
			reqElm1.name='pass';
			reqElm1.value=md5Text.value;
			form.appendChild(reqElm0);
			document.body.appendChild(form)

			form.submit();
}


}
</script>
</body>
</html>