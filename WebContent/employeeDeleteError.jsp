<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員削除エラー画面</title>
<link rel="stylesheet" href="error.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="error-title">SORRY</p>
<%=session.getAttribute("empCode") %>の従業員情報が削除できませんでした
<br>
時間をおいて再度削除処理をおこなってください
<form action="EmployeeListServlet" method="POST">
<input class="submit" type="submit" value="従業員一覧に戻る">
</form>
</div>
</body>
</html>