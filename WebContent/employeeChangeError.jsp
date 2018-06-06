<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員変更エラー画面</title>
<link rel="Stylesheet" href="error.css" type="text/css" media="all" />
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