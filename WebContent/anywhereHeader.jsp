<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="anywhereHeader.css" type="text/css"/>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
</head>

	<%UserBean user = (UserBean)session.getAttribute("user");%>
	<% 	if(user == null){response.sendRedirect("login.jsp");}else{%>
<div id="back">

		<span class="one"><strong id="black">従業員管理システム</strong></span>

	<ul id="menu">
		<li class="active" ><form method="post" name="form1" action="EmployeeListServlet">
		    <input type="hidden" name="ACTION" value="従業員一覧">
		    <a href="javascript:form1.submit()"><strong>従業員一覧</strong><span>company</span></a>
		</form></li>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){ %>
		<li class="active"><form method="post" name="form2" action="EmployeeRegistrationServlet">
		    <input type="hidden" name="ACTION" value="従業員情報登録">
		    <a href="javascript:form2.submit()"><strong>従業員情報登録</strong><span>company</span></a>
		</form></li>
		<%} %>

		<%if(user.getSectionCode().equals("S1")){ %>
		<li class="active"><form method="post" name="form3" action="LicenseRegistrationServlet">
		    <input type="hidden" name="ACTION" value="保有資格追加">
		    <a href="javascript:form3.submit()"><strong>保有資格追加</strong><span>company</span></a>
		</form></li>
		<li class="active"><form method="post" name="form4" action="LicenseAddServlet">
		    <input type="hidden" name="ACTION" value="新規資格追加">
		    <a href="javascript:form4.submit()"><strong>新規資格追加</strong><span>company</span></a>
		</form></li>
		<%} %>

		<%if(user.getSectionCode().equals("S1") || user.getSectionCode().equals("S2")){%>
		<li class="active"><form method="post" name="form5" action="ChangeLogServlet">
		    <input type="hidden" name="ACTION" value="情報の変更ログを表示">
		    <a href="javascript:form5.submit()"><strong>情報の変更ログ</strong><span>company</span></a>
		</form></li>

		<%} %>
		<%if(user.getSectionCode().equals("S1")){ %>
		<li class="active"><form method="post" name="form6" action="UserRegistrationServlet">
		    <input type="hidden" name="ACTION" value="システム利用者追加">
		    <a href="javascript:form6.submit()"><strong>システム利用者追加</strong><span>company</span></a>
		</form></li>
		<%} %>

		<li class="active"><form method="post" name="form7" action="LogoutServlet">
		    <input type="hidden" name="ACTION" value="ログアウト">
		    <a href="javascript:form7.submit()"><strong>ログアウト</strong><span>company</span></a>
		</form></li>
	</ul>
	</div>
<%} %>
</html>