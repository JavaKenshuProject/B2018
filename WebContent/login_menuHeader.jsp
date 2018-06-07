<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="login_menuHeader.css" type="text/css"/>
<meta name="author" content="Namioka Saki">
</head>

	<%UserBean user = (UserBean)session.getAttribute("user");%>

	<ul id="menu">

		<li id="menu00">従業員管理システム</li>
	<%if(user!=null){ %>
		<li id="menu01"><form method="post" name="form7" action="LogoutServlet">
		    <input type="hidden" name="ACTION" value="ログアウト">
		    <a href="javascript:form7.submit()">ログアウト</a>
		</form></li>
		<%} %>

	</ul>
</html>