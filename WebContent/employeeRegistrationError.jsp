<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
<link rel="stylesheet" href="error.css" type="text/css">
</head>

<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="error-title">SORRY</p>
		従業員情報を登録できませんでした<br>
		各項目を正しく入力してください
		<form>
		<a href="employeeRegistration.jsp"><input class="submit" id="back_button" type="button"  value="　戻る　"></a>
	</form>
</div>

</body>
</html>