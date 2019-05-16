<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.DetailBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DetailBean"%>
<%
	ArrayList<DetailBean> dlist = new ArrayList<DetailBean>();
	dlist = (ArrayList<DetailBean>)request.getAttribute("dlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%for(DetailBean detail:dlist){%>

<form action="DetailChange" method="post"enctype="multipart/form-data" >
<ul style="width:200px">
    <li><input type="text" value="<%=detail.getDetailId()%>" name="contName"></li>
    <li style="height:288.58px"><input type=image src="GetPicture?id=<%=detail.getImaId() %>" name=button1 width="200px" ></li>

    <li>画像:<input type="file" name="file" size="30"caoture="camera" /></li>
    <li class=come style="font-size:12px;"><input type="text" name="note" value="<%=detail.getNote2()%>" ></li>
 </ul>
 <input type="hidden" value="<%=detail.getContId()%>" name="contId">
 <input type="submit" value="コンテンツ変更">
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