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
正しく表示できませんでした
<br>
<%=exception.getMessage() %>
時間をおいて再度アクセスしてください
<input class="submit" type="button" value="　戻る　">
</div>
</body>
</html>