<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="error.css" type="text/css">
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
<title>新規資格登録エラー</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="error-title">SORRY</p>
		新規資格を登録できませんでした<br>
		正しく入力してください
		<form action="licenseAdd.jsp" method="POST">
		<input class="submit" id="back_button" type="submit" value="戻る">
	</form>
</div>

</body>
</html>