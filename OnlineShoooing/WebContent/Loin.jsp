<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   	//seddion変数の取得
	String Decision=null;
    Decision=(String)request.getAttribute("login");
	String error="Idまたはpasswordが違います。";
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(Decision=="NG"){
	%>
	<%=error %>
	<%} %>

	メールアドレス：<input type="text"id="mail"><br>
	パスワード：<input type="password" id ="pass"><br>
			<input type="button" value="ログイン" onclick="dispText()">

			<input style=border:none type="password" id="md5Text" size="0" readonly="readonly">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/MD5.js"></script>
<script >

function dispText(){
	var mail=document.getElementById("mail").value;
	var pass=document.getElementById("pass").value;
	var orig = document.getElementById("pass");
	  var md5Text = document.getElementById("md5Text");

	  md5Text.value = CybozuLabs.MD5.calc(orig.value);
	  var form = document.createElement('form');

		form.method='POST';

		form.action ='Loin';

		var reqElm0 =document.createElement('input');
		var reqElm1 =document.createElement('input');



		reqElm0.name='mail';
		reqElm0.value=mail;
		reqElm1.name='pass';
		reqElm1.value=md5Text.value;

		form.appendChild(reqElm0);
		form.appendChild(reqElm1);

		document.body.appendChild(form)

		form.submit();
	}
</script>


</body>
</html>