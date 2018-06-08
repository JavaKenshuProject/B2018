<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset ="UTF-8">
<title>従業員情報登録完了</title>
<link rel="stylesheet" href="comp.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="comp-title">登録処理の完了</p>
<br>
従業員の登録を完了しました。<br>
<form class="yoko">
<a href="employeeRegistration.jsp"><input class="button" type="button" value="続けて登録する"></a>
<a href="menu.jsp"><input class="button" type="button" value="メニュー画面へ"></a>
</form>
</div>
</body>
</html>