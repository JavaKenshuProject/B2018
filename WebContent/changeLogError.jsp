<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>エラー</title>
</head>
<body>
<h2>正しく表示できませんでした</h2>
<br>
<%=exception.getMessage() %>
<h3>時間をおいて再度アクセスしてください</h3>
<input type="button" value="戻る">
</body>
</html>