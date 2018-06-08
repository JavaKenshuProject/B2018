<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="comp.css" type="text/css">
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki"><title>保有資格登録の完了</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="comp-title">保有資格登録の完了</p>
保有資格を登録しました。
<form class="yoko" action="licenseRegistration.jsp" method="POST">
<input class="button" type="submit" value="続けて登録する"><span>&nbsp;&nbsp;</span>
</form>
<form class="yoko" action="menu.jsp" method="POST">
<input class="button "type="submit" value="メニュー画面へ">
</form>
</div>

</body>
</html>