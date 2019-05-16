<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BookBean" import="model.OrderBean" import="model.UserBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    UserBean userbean = new UserBean(); 
    userbean = (UserBean)session.getAttribute("user");
    ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
    ArrayList<OrderBean> arrayorder = new ArrayList<OrderBean>();
    arraybook = (ArrayList<BookBean>)session.getAttribute("userbooks");
    arrayorder = (ArrayList<OrderBean>)session.getAttribute("userorder");
    int count = 0;
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
<h1><%= StringEscapeUtils.escapeHtml4(userbean.getName()) %>さんの注文履歴</h1>
<br><br>
<table class="table table-bordered">
<tr><td>注文履歴番号</td>
<td>日時</td>
<td>合計金額</td>

</tr>

<%for(OrderBean order:arrayorder){ %>
	<tr><td><a href="GetOrderdetail?id=<%=order.getO_code()%>&day=<%= order.getDay() %>"><%=order.getO_code()%></a></td>
	<td><%= order.getDay() %></td>
	<td><%= order.getT_price() %></td>
	
	</tr>
<%	} %>
</table>
<br>
<CENTER>
<a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">トップへ</a>
</CENTER>


<%@ include file = "footer.jsp" %>
</body>
</html>