<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.DetailBean" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<DetailBean> dlist = new ArrayList<DetailBean>();
    dlist = (ArrayList<DetailBean>)request.getAttribute("dlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>詳細一覧</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/cont.css" rel="stylesheet" type="text/css">
<%@ include file="head.jsp" %>
</head>
<body class="contdetail">
<article>
<h1>コンテンツ名</h1>
<form action="vote" method="post" name="form1">
<%for(DetailBean detail:dlist){ %>
  <ul style="width:150px">
    <li><img src="GetPicture?id=<%=detail.getImaId()%>" onClick="javascript:document.form1.radio1.click()"></li>
    <li class=come style="font-size:12px;"></li>
    <li class="radio"><input type="radio" name="radio" value="<%=detail.getDetailId()%>" id="radio1"></li>
  </ul>

<%} %>
<p><input type=submit value=投票 class="button" onclick="return myCheck();"></p>
  <br><br>
</form>
</article>


<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
function myCheck(){
    var flag = false;

    for(var i=0; i<document.form1.elements.length-1;i++){
        if(document.form1.elements[i].checked){
	    flag= true;
	    brake;
        }else{
        	flag= false;
        }
    }
    if(!flag){
    	alert("項目が選択されていません。");
    }
    return flag;
}
</script>
</body>
</html>