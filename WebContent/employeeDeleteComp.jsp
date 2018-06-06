<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="employeeDeleteError.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員削除完了画面</title>
<style>
form{
	display: inline;
}
</style>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<h2><%=session.getAttribute("empCode") %>の従業員情報を削除しました</h2>
<br>
<a href="menu.jsp"><input type="button" value="メニューに戻る"></a>
&nbsp;
<form action="EmployeeListServlet" method="POST">
<input type="submit" value="従業員一覧に戻る">
</form>
</body>
</html>