<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
<link rel="Stylesheet" href="employeeChangeError.css" type="text/css" media="all" />
<meta name="author" content="Namioka Saki">
</head>

<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class ="title">変更できませんでした</p>
		<p>各項目を正しく入力してください</p>
		<form action="employeeChange.jsp"method="post">
		<p class="submit"><input id="back_button" type="submit" value="戻る"></p>
	</form>
</div>

</body>
</html>