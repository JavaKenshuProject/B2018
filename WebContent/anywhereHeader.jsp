<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="header.css" type="text/css"/>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
</head>

	<%UserBean user = (UserBean)session.getAttribute("user");%>

	<ul id="menu">

		<li id="menu00">従業員管理システム</li>

		<li id="menu01"><form method="post" name="form1" action="EmployeeListServlet">
		    <input type="hidden" name="ACTION" value="従業員一覧">
		    <a href="javascript:form1.submit()">従業員一覧</a>
		</form></li>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){ %>
		<li id="menu02"><form method="post" name="form2" action="EmployeeRegistarServlet">
		    <input type="hidden" name="ACTION" value="従業員情報登録">
		    <a href="javascript:form2.submit()">従業員情報登録</a>
		</form></li>
		<%} %>

		<%if(user.getSectionCode().equals("S1")){ %>
		<li id="menu03"><form method="post" name="form3" action="LicenseRegistrationServlet">
		    <input type="hidden" name="ACTION" value="保有資格追加">
		    <a href="javascript:form3.submit()">保有資格追加</a>
		</form></li>
		<li id="menu04"><form method="post" name="form4" action="LicenseAddServlet">
		    <input type="hidden" name="ACTION" value="新規資格追加">
		    <a href="javascript:form4.submit()">新規資格追加</a>
		</form></li>
		<%} %>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){%>
		<li id="menu05"><form method="post" name="form5" action="ChangeLogServlet">
		    <input type="hidden" name="ACTION" value="情報の変更ログを表示">
		    <a href="javascript:form5.submit()">変更ログ表示</a>
		</form></li>

		<%} %>
		<%if(user.getSectionCode().equals("S1")){ %>
		<li id="menu06"><form method="post" name="form6" action="UserRegistarServlet">
		    <input type="hidden" name="ACTION" value="システム利用者追加">
		    <a href="javascript:form6.submit()">システム利用者追加</a>
		</form></li>
		<%} %>

		<li id="menu07"><form method="post" name="form7" action="LogoutServlet">
		    <input type="hidden" name="ACTION" value="ログアウト">
		    <a href="javascript:form7.submit()">ログアウト</a>
		</form></li>
	</ul>

</html>