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
<h3>時間をおいて再度アクセスしてください</h3>
<%=exception.getMessage() %>
<a href="menu.jsp"><input type="button" value="メニューに戻る"></a>
</body>
</html>