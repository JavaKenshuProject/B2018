<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.entity.UserBean"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>メニュー画面</title>
			<link rel="stylesheet" href="menu.css" type="text/css">
		</head>
		<body>
	<%@include file="login_menuHeader.jsp" %>
			<div>
			<p class="all-title">メニュー</p>

			<hr><br>
			<form action="EmployeeListServlet" method="post">
				<input type="submit" value="従業員一覧" name="ACTION"><br><br></form>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){ %>
			<form action="EmployeeRegistrationServlet" method="post">
				<input type="submit" value="従業員情報登録" name="ACTION"><br><br></form>
		<%} %>
		<%if(user.getSectionCode().equals("S1")){ %>
			<form action="LicenseRegistrationServlet" method="post">
				<input type="submit" value="保有資格追加" name="ACTION"><br><br></form>

			<form action="LicenseAddServlet" method="post">
				<input type="submit" value="新規資格追加" name="ACTION"><br><br></form>
		<%} %>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){%>
			<form action="ChangeLogServlet" method="post">
				<input type="submit" value="情報の変更ログを表示" name="ACTION"><br><br></form>
		<%} %>
		<%if(user.getSectionCode().equals("S1")){ %>
			<form action="UserRegistrationServlet" method="post">
				<input type="submit" value="システム利用者追加" name="ACTION"><br><br></form>
		<%} %>
			<form action="LogoutServlet" method="post">
				<input type="submit" value="ログアウト" name="ACTION"><br></form>
			</div>
		</body>
	</html>