<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.LicenseBean"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="author" content="Namioka Saki">
<title>新規資格追加</title>
<link rel="stylesheet" href="licenseAdd.css" type="text/css">

</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
	<%LicenseBean license = (LicenseBean)session.getAttribute("licensebean");
	  List<LicenseBean> licenseList = (List<LicenseBean>)session.getAttribute("licenseList");
	%>
<div>

<p class="all-title">新規資格追加</p>


<form class="yoko"  name="submitForm" action="LicenseAddServlet" method="POST" onsubmit="return check();">
<table class="table1">
<tr><td class="td1">
資格コード</td><td class="td2"><input class="form" type="text" name="license_code" pattern="^L[0-9]{4}$" maxlength="5" value="<%if(license!=null){ %><%=license.getLicenseCode() %><%} %>" required></td></tr>
<tr><td class="td1">資格名</td><td class="td2"><input class="form" type="text" name="license_name" maxlength="100" value="<%if(license!=null){ %><%=license.getLicenseName() %><%} %>" required></td></tr>
</table>

<table class="table2">
<tr><td><input class="submit" type="submit" value="追加" name="ACTION">&nbsp;
</form></td>
<td><form class="yoko" action="menu.jsp" method="POST">
<input class="submit" type="submit" value="キャンセル">
</form></td></tr></table>
</div>
<table id="tbl" style="display:none;">
<%for(LicenseBean bean:licenseList){ %>
	<tr>
	<td><%=bean.getLicenseCode() %></td>
	<td><%=bean.getLicenseName() %></td>
	</tr>
<%} %>
</table>
<script>
    function check(){
        var form = document.forms.submitForm;
        var flag = false;
        var msg = "";

        var tblData = document.getElementById("tbl");
        for (var i = 0, rowlen = tblData.rows.length; i < rowlen; i++) {
			if(tblData.rows[i].cells[0].innerText == form.license_code.value){
				flag = true;
				msg += "既に登録されている資格コードです\n";
			}else if(tblData.rows[i].cells[1].innerText == form.license_name.value){
				flag = true;
				msg += "既に登録されている資格名です"
			}
		}

		if(flag){
			alert(msg);
			return false;
		}
        msg = "この内容で資格を追加しますか？";
        var result = confirm(msg);
        return result;
    }
</script>
</body>
</html>