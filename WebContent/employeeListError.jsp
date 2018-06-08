<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>エラー</title>
<link rel="stylesheet" href="error.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="error-title">SORRY</p>
正しく表示できませんでした<br>
時間をおいて再度アクセスしてください
<a href="menu.jsp"><input class="submit2" type="button" value="メニューに戻る"></a>
</div>
</body>
</html>