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
			<p class="form-title">ログアウト完了</p>
			<p>お疲れさまでした</p>
				<input type="submit" value="ログイン画面に戻る">
			</div>
			</form>
		</body>
	</html>