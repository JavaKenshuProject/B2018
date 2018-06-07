<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.LicenseBean"
    import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="licenseRegistration.css" type="text/css">
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
<title>保有資格登録画面</title>
<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で保有資格を登録しますか？";
        var result = confirm(msg);
        return result;
    }
</script>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
<div>
<p class="all-title">従業員の保有資格の登録</p>
<form class="yoko" name="submitForm" action="LicenseRegistrationServlet" method="POST" onsubmit="return check();">
従業員コード：<input type="text" name="emp_code" pattern="^E[0-9]{3}$" maxlength="4" required><br>
資格名：
<select name="license_name">
	<% List<LicenseBean> lclist = (List<LicenseBean>)session.getAttribute("lclist");

	if(lclist != null){
	for(int i=0; i < lclist.size(); i++){
	LicenseBean license =lclist.get(i);%>

	 <option value="<%= license.getLicenseCode() %>"><%= license.getLicenseName() %></option>

	 <%}} %>

</select>
<br>
取得日(任意)：<input type="date" name="get_license_date"  min="0000-01-01" max="9999-12-31"><br>
<br>
<br>
<input class="submit" type="submit" value="追加" name="ACTION">&nbsp;
</form>
<form class="yoko" action="menu.jsp" method="POST">
<input class="submit" type="submit" value="キャンセル">
</form>
</div>
</body>
</html>