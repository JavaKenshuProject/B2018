<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="loginError.jsp" %>
<% 	if(session.getAttribute("user") != null){
		response.sendRedirect("menu.jsp");
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="login.css" type="text/css">
<meta name="author" content="Namioka Saki">
</head>
<body>
	<%@include file="login_menuHeader.jsp" %>
<div  id= "form">
<p class ="form-title">Login</p>
	<form action="LoginServlet" method="post" >
		<p>ユーザーID</p>
		<p class="id"><input type="text" placeholder="IDを入力してください"  name="user_id" required></p>
		<p>パスワード</p>
		<p class="pass"><input type="password" placeholder="パスワードを入力してください" name="password" required></p>
		<p class="Psubmit"><input class="submit" type="submit" name="ACTION" value="ログイン"></p>
	</form>
</div>

</body>
</html>