<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.AddtoBean" %>
	<%AddtoBean product = (AddtoBean)request.getAttribute("name"); %>
	<%
	int resul=1;
	int resul1=2;
	int resul2=3;
	String medicine = String.valueOf(resul);
	String medicine2 = String.valueOf(resul1);
	String medicine3 = String.valueOf(resul2);
	String Agent=null;
	if(product.getDescription()==medicine){
		Agent="固形型";

	}else if(product.getDescription()==medicine2){
		Agent="砂型";
	}else if(product.getDescription()==medicine3){
		Agent="液体型";
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録商品の確認</title>
</head>
<body>
<jsp:include page="top.jsp"/>
名前：<%=product.getName()%><br>
説明：<%=product.getDescr() %><br>
区分：<%=Agent %><br>
金額：<%=product.getPrice() %><br>
<a href="/Addto.jsp">商品追加</a><a href="/Management.jsp">管理者画面</a>
</body>
</html>