<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
<title>新規資格追加画面</title>
<link rel="stylesheet" href="licenseAdd.css" type="text/css">

</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="all-title">新規資格の追加</p>
<form class="yoko"  name="submitForm" action="LicenseAddServlet"method="POST" onsubmit="return check();">
資格コード：<input type="text" name="license_code" pattern="^L[0-9]{4}$" maxlength="5" required><br>
資格名：<input type="text" name="license_name" maxlength="100" required><br>
<br>
<input class="submit" type="submit" value="追加" name="ACTION">&nbsp;
</form>
<form class="yoko" action="menu.jsp" method="POST">
<input class="submit" type="submit" value="キャンセル">
</form>
</div>
<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で資格を追加しますか？";
        var result = confirm(msg);
        return result;
    }
</script>
</body>
</html>