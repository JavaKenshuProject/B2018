<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインエラー</title>
<link rel="Stylesheet" href="loginError.css" type="text/css" media="all" />
<meta name="author" content="Namioka Saki">
</head>

<body>
	<%@include file="login_menuHeader.jsp"%>
	<div>
		<p class="title">SORRY</p>
		<p>
			ログインできませんでした<br> ユーザIDとパスワードを正しく入力してください
		</p>
		<form action="login.jsp">
			<p class="submit">
				<input id="back_button" type="submit" value="ログイン画面に戻る">
			</p>
		</form>
	</div>

</body>
</html>