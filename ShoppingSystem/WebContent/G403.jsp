<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    ArrayList<UserBean> arrayuser = new ArrayList<UserBean>();
    arrayuser = (ArrayList<UserBean>)session.getAttribute("alluser");
    UserBean users = (UserBean)session.getAttribute("user");
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
<%if(StringEscapeUtils.escapeHtml4(users.getAuthority())==null){%>
	<meta http-equiv="refresh"content="1; url=LoginUser">
<%}else{	%>
<br><br>
<h2>ユーザ一覧</h2>
<table class="table table-bordered">
<tr><td>ユーザID</td>
<td>氏名</td>
<td>氏名(よみ)</td>
<td>郵便番号</td>
<td>住所</td>
<td>電話番号</td>
<td>管理者権限</td>

<%for(UserBean user:arrayuser){ %>
<tr><td><a href="UserUpdate2?id=<%=StringEscapeUtils.escapeHtml4(user.getM_add())%>"><%=StringEscapeUtils.escapeHtml4(user.getM_add())%></a></td>
	<td><%= StringEscapeUtils.escapeHtml4(user.getName()) %></td>
	<td><%= StringEscapeUtils.escapeHtml4(user.getName_y()) %></td>
	<td><%= user.getP_code() %></td>
	<td><%= StringEscapeUtils.escapeHtml4(user.getS_add()) %></td>
	<td><%= StringEscapeUtils.escapeHtml4(user.getT_code()) %></td>
	<%if(StringEscapeUtils.escapeHtml4(user.getAuthority())==null){ %>
	<td>なし</td>
	<%}else{ %>
	<td>あり</td>
	<%} %>
	</tr>
<%} %>
</table>
<br>
<CENTER>
<a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">トップへ戻る</a>
</CENTER>


<%@ include file = "footer.jsp" %>
<%} %>
</body>
</html>