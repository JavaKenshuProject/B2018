<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>新規資格追加画面</title>
</head>
<body>

<h1>新規資格の追加</h1>
<form action="LicenseAddSerlet"method="POST">
資格コード：<input type="text" name="license_code"><br>
資格名：<input type="text" name="license_name"><br>
<br>
<input type="submit" value="追加" name="Action">&nbsp;
</form>
<form action="menu.jsp" method="POST">
<input type="submit" value="キャンセル">
</form>

</body>
</html>