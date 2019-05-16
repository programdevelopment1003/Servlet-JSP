<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<link href="css/contA.css" rel="stylesheet" type="text/css">
<%@ include file="headA.jsp" %>
</head>
<body>
<header id="header">
    <a href="G201.html"><img src="画像ap/ホームt.png" width="100px"></a>
    <a class=logout href="test.html"><img src="画像ap/out.png" width=80px></a>
    <a class=logout href="G205.html"><img src="画像ap/追加.jpg" width="80px"></a>
    <ul>
      <li><a href="G104.html">ユーザ名</a></li>
    </ul>
  </header>

  <article>
  <p id="slideshow">
    <img src="img/img1.jpg" alt="画像1" class="active" width="100%">
    <img src="img/img2.jpg" alt="画像2" width="100%">
    <img src="img/img3.jpg" alt="画像3" width="100%">
    <img src="img/img4.jpg" alt="画像4" width="100%">
    <img src="img/img5.png" alt="画像5" width="100%">
  </p>

<%for(ContBean cont:clist){%>
<div style="display:inline-flex">
<form action="ContChange" method="post"enctype="multipart/form-data" >
<ul style="width:200px">
    <li><input type="text" value="<%=cont.getContName()%>" name="contName"></li>
    <li style="height:288.58px"><input type=image src="GetPicture?id=<%=cont.getImageId() %>" name=button1 width="200px" ></li>

    <li>画像:<input type="file" name="file" size="30"caoture="camera" /></li>
    <li><input type="text" name="start" value="<%=cont.getStart()%>">
         ～  <input type="text" name ="end" value="<%=cont.getEnd()%>"></li><br>
    <li class=come style="font-size:12px;"><input type="text" name="note" value="<%=cont.getNote()%>" ></li>
 </ul><br>
 <input type="hidden" value="<%=cont.getContId()%>" name="contId">
 <input type="hidden" value="<%=cont.getImageId()%>" name="imageId">
<li><input class=button type=submit value="コンテンツ変更"></li></form><br>
</div>

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