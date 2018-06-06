<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.entity.EmployeeBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員変更完了画面</title>
<link rel="stylesheet" href="comp.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<%EmployeeBean emp = (EmployeeBean)session.getAttribute("employee"); %>
<p class="all-title"><%=emp.getEmpCode() %>の従業員の情報を変更しました</p>
<br>
<a href="menu.jsp"><input type="button" value="メニューに戻る"></a>
&nbsp;
<form action="EmployeeListServlet" method="POST">
<input type="submit" value="従業員一覧に戻る">
</form>
</div>
</body>
</html>