<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String getname=(String)session.getAttribute("number");
%>
<%int human = Integer.parseInt(getname); %>
<html class="content2">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>投票</title>
<link href="css/insert.css" rel="stylesheet" type="text/css">
</head>
<body>
    
  <h2 class=cont2>コンテンツ追加</h2><h4>コンテンツ詳細</h4>

  <form action="G206" method="post"enctype="multipart/form-data" >
      <%for(int i =0;i<human;i++){

        String s = String.valueOf(i);
        String name ="name"+s;
        String img="img"+s;
        String De="De"+s;%>
  

  <table>
    <tr>
      <th>1</th>
      <th>種類名</th>
      <td><input type="text" name=<%=name%>></td>
    </tr>
    <tr>
      <th></th>
      <th>画像</th>
      <td><input type="file" name=<%=img %> caoture="camera" ></td>
    </tr>
  </table>
  <table>
    <%}%>
  <a class="share_btn2 shbk" href="G205.jsp">戻る</a>
  <input class="share_btn2 shtw" type="submit" value="コンテンツ追加">

</form>

</body>
</html>