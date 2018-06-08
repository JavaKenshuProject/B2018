<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.LicenseBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
<title>新規資格追加画面</title>
<link rel="stylesheet" href="licenseAdd.css" type="text/css">

</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
	<%LicenseBean license = (LicenseBean)session.getAttribute("licensebean"); %>
<div>

<p class="all-title">新規資格の追加</p>


<form class="yoko"  name="submitForm" action="LicenseAddServlet"method="POST" onsubmit="return check();">
<table class="table1">
<tr><td class="td1">
資格コード  ※必須</td><td class="td2"><input class="form" type="text" name="license_code" pattern="^L[0-9]{4}$" maxlength="5" value="<%if(license!=null){ %><%=license.getLicenseCode() %><%} %>" required></td></tr>
<tr><td class="td1">資格名　　 ※必須</td><td class="td2"><input class="form" type="text" name="license_name" maxlength="100" value="<%if(license!=null){ %><%=license.getLicenseName() %><%} %>" required></td></tr>
</table>

<table class="table2">
<tr><td><input class="submit" type="submit" value="追加" name="ACTION">&nbsp;
</form></td>
<td><form class="yoko" action="menu.jsp" method="POST">
<input class="submit" type="submit" value="キャンセル">
</form></td></tr></table>
</div>
<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で資格を追加しますか？";
        var result = confirm(msg);
        return result;
    }
</script>
</body>
</html>