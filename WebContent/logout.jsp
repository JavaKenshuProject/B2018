<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>ログアウト画面</title>
			<link rel="stylesheet" href="logout.css" type="text/css">
		</head>
		<body>
	<%@include file="login_menuHeader.jsp" %>
		<form action="login.jsp" method ="post">

			<div>
			<p class="all-title">ログアウト完了</p>
			<p class="mess">お疲れさまでした</p>
				<input class="button" type="submit" value="ログイン画面に戻る">
			</div>
			</form>
		</body>
	</html>