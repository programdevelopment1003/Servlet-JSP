<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BookBean" import="model.CartBean" import="java.util.ArrayList" import="org.apache.commons.lang3.StringEscapeUtils"%>
    <%
    ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
    ArrayList<CartBean> arraycart = new ArrayList<CartBean>();
    ArrayList<String> cartmsg = new ArrayList<String>();
    cartmsg = (ArrayList<String>)session.getAttribute("cartmsg");
    arraybook = (ArrayList<BookBean>)session.getAttribute("userbooks");
    arraycart = (ArrayList<CartBean>)session.getAttribute("usercart");
    CartBean cart = new CartBean();
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
<h1>カート</h1>
<br><br>
<table class="table table-bordered">
<tr><td>書籍ID</td>
<td>書籍名</td>
<td>書籍名(よみ)</td>
<td>単価</td>
<td>著者ID</td>
<td>ジャンルID</td>
<td>在庫数</td>
<td>購入数量</td>

<td>カートから削除</td>
</tr>

<%for(BookBean book:arraybook){ 
	
	CartBean cartbean = new CartBean();
	cartbean = arraycart.get(count);%>
	<tr><td><a href="BookUpdate?id=<%=book.getB_id()%>"><%=book.getB_id()%></a></td>
	<td><%= StringEscapeUtils.escapeHtml4(book.getB_name()) %></td>
	<td><%= StringEscapeUtils.escapeHtml4(book.getB_namey()) %></td>
	<td><%= book.getPrice() %></td>
	<td><%= book.getA_id() %></td>
	<td><%= book.getG_id() %></td>
	<td><%= book.getStock() %></td>
	<td><%= cartbean.getSuryo() %></td>
	
	<td><a href="CartDelete?id=<%=cartbean.getC_id()%>">削除</a></td>
	</tr>
	<%	count++;
	} %>
</table>
<br>

<CENTER>
<%if(cartmsg.size()==0 && arraycart.size()>0){ %>
<a class="button" href="CartSettlement">決済</a><br><br>
<%}else{
	for(String msg: cartmsg){%>
	<p><%=StringEscapeUtils.escapeHtml4(msg) %></p>

<%	}
} %>
<a class="button" href="<%=StringEscapeUtils.escapeHtml4(path_h) %>">トップへ</a><br><br>
<a class="button" href="BookAllOut">商品一覧へ</a>
</CENTER>


<%@ include file = "footer.jsp" %>
</body>
</html>