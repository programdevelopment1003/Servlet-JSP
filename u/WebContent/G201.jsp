<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.ContBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ContBean"%>
<%
	ArrayList<ContBean> clist = new ArrayList<ContBean>();
	clist = (ArrayList<ContBean>)request.getAttribute("clist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コンテンツ一覧</title>
<link href="css/cont.css" rel="stylesheet" type="text/css">
<%@ include file="head.jsp" %>
</head>
<body>
<article>
<p id="slideshow">
    <img src="img/img1.jpg" alt="画像1" class="active" width="100%">
    <img src="img/img2.jpg" alt="画像2" width="100%">
    <img src="img/img3.jpg" alt="画像3" width="100%">
    <img src="img/img4.jpg" alt="画像4" width="100%">
    <img src="img/img5.png" alt="画像5" width="100%">
</p>

<%for(ContBean cont:clist){ %>
<form action="ContDetail" method="get">
<ul style="width:200px">
    <li><%=cont.getContName() %></li>
    <li style="height:288.58px"><input type=image src="GetPicture?id=<%=cont.getImageId() %>" name=button1 width="200px" ></li>
    <li>期間：<%=cont.getStart() %>～<%=cont.getEnd()%></li><br>
    <li class=come style="font-size:12px;"><%=cont.getNote()%></li>
 </ul>
<input type="hidden" value="<%=cont.getContId()%>" name="contId">
</form>
<%} %>
</article>

<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
function slideSwitch() {
  var $active = $('#slideshow img.active');

  if ( $active.length == 0 ) $active = $('#slideshow img:last');

  var $next =  $active.next().length ? $active.next()
     : $('#slideshow img:first');

  $active.addClass('last-active');

  $next.css({opacity: 0.0})
     .addClass('active')
     .animate({opacity: 1.0}, 1000, function() {
          $active.removeClass('active last-active');
     });
}

$(function() {
  setInterval( "slideSwitch()", 3000 );
});
</script>
</body>
</html>