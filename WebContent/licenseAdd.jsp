<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
<title>新規資格追加画面</title>
<link rel="stylesheet" href="ManagementSystem.css" type="text/css">
<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で登録しますか？";
        var result = confirm(msg);
        return result;
    }
</script>

</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="all-title">新規資格の追加</p>
<form  name="submitForm" action="LicenseAddServlet"method="POST" onsubmit="return check();">
資格コード：<input type="text" name="license_code" required><br>
資格名：<input type="text" name="license_name" required><br>
<br>
<input type="submit" value="追加" name="ACTION">&nbsp;
</form>
<form action="menu.jsp" method="POST">
<input type="submit" value="キャンセル">
</form>
</div>
</body>
</html>