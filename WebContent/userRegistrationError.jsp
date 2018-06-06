<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
<link rel="stylesheet" href="ManagementSystem.css" type="text/css">
</head>

<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="all-title">登録できませんでした</p>
		<p>各項目を正しく入力してください</p>
		<form action="post">
		<p class="submit"><a href="userRegistration.jsp"><input id="back_button" type="button" value="戻る"></a></p>
	</form>
</div>

</body>
</html>