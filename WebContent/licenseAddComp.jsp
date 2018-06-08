<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Namioka Saki">
<link rel="stylesheet" href="comp.css" type="text/css">
<title>新規資格登録の完了</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="comp-title">登録処理の完了</p>
<br>
新規資格登録を完了しました。<br>
<form class="yoko" action="licenseAdd.jsp" method="POST">
<input class="button" type="submit" value="続けて登録"><span>&nbsp;&nbsp;</span>
</form>
<form class="yoko" action="menu.jsp" method="POST">
<input class="button" type="submit" value="メニュー画面へ">
</form>
</div>

</body>
</html>