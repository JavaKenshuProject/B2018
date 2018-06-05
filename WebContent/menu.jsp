<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>メニュー画面</title>
			<link rel="stylesheet" href="menu_style.css" type="text/css">
		</head>
		<body>
			<div class="box">
			<h1>メニュー</h1>
			<hr><br>
			<form action="EmployeeListServlet" method="post">
				<input type="submit" value="従業員一覧"><br><br></form>
			<form action="EmployeeRegistarServlet" method="post">
				<input type="submit" value="従業員情報登録"><br><br></form>
			<form action="LicenseRegistrationServlet" method="post">
				<input type="submit" value="保有資格追加"><br><br></form>
			<form action="LicenseAddServlet" method="post">
				<input type="submit" value="新規資格追加"><br><br></form>
			<form action="ChangeLogServlet" method="post">
				<input type="submit" value="情報の変更ログを表示"><br><br></form>
			<form action="UserRegistarServlet" method="post">
				<input type="submit" value="システム利用者追加"><br><br></form>
			<form action="LogoutServlet" method="post">
				<input type="submit" value="ログアウト"><br></form>
			</div>
		</body>
	</html>