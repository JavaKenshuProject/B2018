<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="menu.css" type="text/css">
</head>
<body>
	<%@include file="login_menuHeader.jsp"%>
<div class="divdiv">
	<% 	if(user == null){response.sendRedirect("login.jsp");}else{%>

			<form class="menu" action="EmployeeListServlet" method="post">
					<span><input id="b1" class="all" type="submit" value="従業員一覧" name="ACTION"></span>

				</form>

				<%
				 if (user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")) {
				%>
				<form class="menu" action="EmployeeRegistrationServlet" method="post">
					<span><input id="b2" class="all" type="submit" value="従業員情報登録" name="ACTION"></span>
				</form> <%
 	}
 %>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<form class="menu" action="LicenseRegistrationServlet" method="post">
					<span><input id="b3" class="all" type="submit" value="保有資格追加" name="ACTION"></span>
				</form>

			<form  class="menu"action="LicenseAddServlet" method="post">
					<span><input id="b4" class="all" type="submit" value="新規資格追加" name="ACTION"></span>
				</form> <%
 	}
 %>

				<%
					if (user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")) {
				%>
				<form  class="menu"action="ChangeLogServlet" method="post">
					<span><input id="b5" class="all" type="submit" value="情報の変更ログ" name="ACTION"></span>
				</form> <%
 	}
 %>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<form class="menu" action="UserRegistrationServlet" method="post">
					<span><input id="b6" class="all" type="submit" value="システム利用者追加" name="ACTION"></span>
				</form> <%} %>
				</div>
<%} %>
<div class="iconAuthor">Icon made by <a href="https://jp.freepik.com/flaticon">FLATICON</a></div>
</body>
</html>
