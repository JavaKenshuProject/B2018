<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="employeeDeleteError.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員削除完了画面</title>
<link rel="stylesheet" href="comp.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="comp-title">従業員情報の削除完了</p>
<br>
<%=session.getAttribute("empCode") %>の従業員情報を削除しました<br>
<form class="yoko"><a href="menu.jsp"><input class="button" type="button" value="メニューに戻る"></a></form>
&nbsp;
<form class="yoko" action="EmployeeListServlet" method="POST">
<input class="button" type="submit" value="従業員一覧に戻る">
</form>
</div>
</body>
</html>