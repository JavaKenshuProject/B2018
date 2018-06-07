<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインエラー</title>
<link rel="stylesheet" href="error.css" type="text/css">
<meta name="author" content="Namioka Saki">
</head>

<body>
	<%@include file="login_menuHeader.jsp"%>
	<div>
		<p class="error-title">SORRY</p>
			ログインできませんでした<br> ユーザIDとパスワードを正しく入力してください

		<form action="login.jsp">
				<input class="submit "id="back_button" type="submit" value="ログイン画面に戻る">

		</form>
	</div>

</body>
</html>