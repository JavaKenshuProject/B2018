<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>保有資格登録エラー</title>
<link rel="stylesheet" href="error.css" type="text/css">
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="error-title">SORRY</p>
		保有資格を登録できませんでした<br>
		各項目を正しく入力してください
		<form action="LicenseRegistrationServlet" method="POST">
		<input class="submit" id="back_button" type="submit" value="　戻る　">
	</form>
</div>

</body>
</html>