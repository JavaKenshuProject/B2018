<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="ManagementSystem.css" type="text/css">
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki"><title>保有資格登録の完了</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="all-title">保有資格の登録が完了しました。</p>
<form action="licenseRegistration.jsp" method="POST">
<input type="submit" value="続けて登録する"><span>&nbsp;&nbsp;</span>
</form>
<form action="menu.jsp" method="POST">
<input type="submit" value="メニュー画面へ">
</form>
</div>

</body>
</html>