<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="loginError.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="Stylesheet" href="Login.css" type="text/css" media="all" />
<meta name="author" content="Namioka Saki">
</head>
<body>
<div  id= "form">
<p class ="form-title">Login</p>
	<form action="LoginServlet" method="post" >
		<p>ユーザーID</p>
		<p class="id"><input type="text" placeholder="IDを入力してください"  name="user_id"></p>
		<p>パスワード</p>
		<p class="pass"><input type="password" placeholder="パスワードを入力してください" name="password"></p>
		<p class="submit"><input class="submit" type="submit" name="ACTION" value="ログイン"></p>
	</form>
</div>

</body>
</html>