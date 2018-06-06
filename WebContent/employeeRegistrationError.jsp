<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
<link rel="Stylesheet" href="employeeRegistrationError.css" type="text/css" media="all" />
</head>

<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class ="title">従業員情報を登録できませんでした</p>
		<p>各項目を正しく入力してください</p>
		<form>
		<p class="submit"><a href="employeeRegistration.jsp"><input id="back_button" type="button"  value="戻る"></a></p>
	</form>
</div>

</body>
</html>