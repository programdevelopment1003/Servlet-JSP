<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.apache.commons.lang3.StringEscapeUtils" %>
    <%
    String Msg1 = (String)session.getAttribute("msg2");
    String Msg2 = (String)session.getAttribute("msg3");
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

<form name="form" action="NewUser" method="POST">
	<h1>新規ユーザ登録</h1><br><br>
	<%
	if(StringEscapeUtils.escapeHtml4(Msg2)==null){
	%>
	<%}else{ %>
	<CENTER>
	<%= StringEscapeUtils.escapeHtml4(Msg2) %>
	</CENTER><br>
	<%} %>
	ユーザID(メールアドレス)：<input type="text" id="pass" placeholder="" name="id"><br>
	パスワード：<input type="text" id="pass" placeholder="半角英数8字以上12字以内" name="password"><br>
	郵便番号：<input type="text" id="pass" placeholder="" name="pcode"><br>
	住所：<input type="text" id="pass" placeholder="" name="sadd"><br>
	電話番号：<input type="text" id="pass" placeholder="" name="tcode"><br>
	氏名：<input type="text" id="pass" placeholder="" name="name"><br>
	氏名（よみがな）：<input type="text" id="pass" placeholder="" name="namey"><br>
	
	<input type="submit" value="登録"><br><br>
  <a class="button" href="G101.jsp">キャンセル</a>
</form>

<%@ include file = "footer.jsp" %>
</body>

</html>