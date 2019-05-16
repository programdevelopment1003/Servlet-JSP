<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BookBean" import="model.OrderdetailBean" import="model.UserBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
    ArrayList<OrderdetailBean> arrayorderdetail = new ArrayList<OrderdetailBean>();
    arraybook = (ArrayList<BookBean>)session.getAttribute("userbooks");
    String day = (String)session.getAttribute("orderday");
    arrayorderdetail = (ArrayList<OrderdetailBean>)session.getAttribute("userorderdetail");
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
<h1><%=StringEscapeUtils.escapeHtml4(day) %>の注文履歴</h1>
<br><br>
<table class="table table-bordered">
<tr>
<td>書籍ID</td>
<td>数量</td>
<td>単価</td>

</tr>

<%for(OrderdetailBean order:arrayorderdetail){ %>
	<tr>
	<td><%= order.getB_id() %></td>
	<td><%= order.getSuryo() %></td>
	<td><%= order.getPrice() %></td>
	
	</tr>
<%} %>
</table>
<br>
<CENTER>
<a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">トップへ</a><br><br>
<a class="button" href="GetOrder">注文履歴一覧へ</a>
</CENTER>


<%@ include file = "footer.jsp" %>
</body>
</html>