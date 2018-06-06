<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="licenceAddError.css" type="text/css"  />
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
<title>新規資格登録エラー</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class ="title">新規資格を登録できませんでした</p>
		<p>正しく入力してください</p>
		<form action="licenseAdd.jsp" method="POST">
		<p class="submit"><input id="back_button" type="submit" value="戻る"></p>
	</form>
</div>

</body>
</html>