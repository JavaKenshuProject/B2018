<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員削除エラー画面</title>
</head>
<body>
<h2><%=session.getAttribute("empCode") %>の従業員情報が削除できませんでした</h2>
<br>
<h3>時間をおいて再度削除処理をおこなってください</h3>
<form action="EmployeeListServlet" method="POST">
<input type="submit" value="戻る">
</form>
</body>
</html>