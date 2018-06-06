<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>従業員情報変更画面</title>
			<link rel="stylesheet" href="employeeChange_style.css" type="text/css">
		</head>
		<body>
			<div class="box">
			<h1>従業員情報変更</h1>
			<h2>現在の内容</h2>
			氏名：○○　　氏名（フリガナ）：○○　　性別：○○　　所属部署名：○○
			<br>
			<hr>
			<br>
			<h2>変更内容</h2>
				氏：<input type="text">　　名：<input type="text"><br>
				氏（フリガナ）：<input type="text">　　名（フリガナ）：<input type="text"><br>
				性別：<input type="radio">男
					  <input type="radio">女<br>
				所属部署名：<select>
					<option>選択してください</option>
					<option value="総務部">総務部</option>
					<option value="人事部">人事部</option>
				</select>
				<br>
				<hr>
				<br>
				<form action="EmployeeChangeServlet" method="post">
				<input type="submit" value="変更"></form>>
				<form action="employeeList.jsp">
				<input type="submit" value="キャンセル"></form>
			</div>
		</body>
	</html>