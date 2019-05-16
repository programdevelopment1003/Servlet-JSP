<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>投票</title>
<link href="css/insert.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String error =null;
error=(String)request.getAttribute("error"); %>
<%if(error !=null){ %>
<%=error %>
<%} %>


  <h2>コンテンツ追加</h2>

  <form action="G205" method="post" name="form1"enctype="multipart/form-data">

  <table>
    <tr>
      <th>コンテンツ名</th>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <th>画像</th>
      <td><input type="file" name="img" caoture="camera" ></td>
    </tr>
    <tr>
      <th>備考</th>
      <td><textarea name="text" cols="30" rows="4" maxlength="48"></textarea ></td>
    </tr>
    <tr>
      <th>開催日</th>
      <td><input type="text" name="start" size="10" placeholder="2018-01-01">～<input type="text" name="end" size="10" placeholder="2018-02-01"></td>
    </tr>
    <tr>
      <th>コンテンツ数</th>
      <td><input type="number" name="number" min="2" max="100" placeholder="2以上"></td>
    </tr>
  </table>

  <a class="share_btn2 shfb" href="">キャンセル</a>
  <input class="share_btn2 shtw" type="submit"onclick="checkForm()" value="次へ">

</form>
<script>
function checkForm(){
    if(document.form1.name.value == "" || document.form1.img.value == ""
    		|| document.form1.text.value == "" || document.form1.start.value == ""
        	|| document.form1.end.value == "" || document.form1.number.value == ""){
        alert("全項目を入力して下さい。");
    	return false;
    } else{
    	return true
    }
}
</script>
</body>
</html>