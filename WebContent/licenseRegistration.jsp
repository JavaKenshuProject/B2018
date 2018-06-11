<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.entity.LicenseBean"
    import="model.entity.EmployeeBean"
    import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="licenseRegistration.css" type="text/css">
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
<title>保有資格登録画面</title>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
	<% LicenseBean regLicense = (LicenseBean)session.getAttribute("licensebean"); %>
	<% List<EmployeeBean> empList = (List<EmployeeBean>)session.getAttribute("emplist");%>
<div>


<p class="all-title">保有資格追加</p>

<table class="table1">
<tr><td class="td1">
<form class="yoko" name="submitForm" action="LicenseRegistrationServlet" method="POST" onsubmit="return check();">
従業員コード<br>（E***の形式 例：E001）</td><td class="td2"><input class="form" type="text" name="emp_code" pattern="^E[0-9]{3}$" maxlength="4" value="<%if(regLicense!=null){%><%=regLicense.getEmpCode() %><%}%>" required></td></tr>
<tr><td class="td1">資格名</td>
<td class="td2"><select name="license_name">
	<% List<LicenseBean> lclist = (List<LicenseBean>)session.getAttribute("lclist");

	if(lclist != null){
	for(int i=0; i < lclist.size(); i++){
	LicenseBean license =lclist.get(i);%>

	 <option value="<%= license.getLicenseCode() %>" <%if(regLicense!=null && license.getLicenseCode().equals(regLicense.getLicenseCode()) ){%>selected<%}%>><%= license.getLicenseName() %></option>

	 <%}} %>

</select></td></tr>
<tr><td class="td1">
取得日(任意)</td><td class="td2"><input class="form" type="date" id="date" name="get_license_date" min="0000-01-01"  value="<%if(regLicense!=null){%><%=regLicense.getGetLicenseDate() %><%}%>"></td></tr>
</table>
<table class="table2">
<tr><td>
<input class="submit" type="submit" value="追加" name="ACTION">
</form></td><td>
<form class="yoko" action="menu.jsp" method="POST">
<input class="submit" type="submit" value="キャンセル">
</form></td></tr></table>
</div>

<table id="tbl" style="display:none;">
<%for(EmployeeBean bean:empList){ %>
	<tr>
	<td><%=bean.getEmpCode() %></td>
	</tr>
<%} %>
</table>

<script>
    function check(){
        var form = document.forms.submitForm;
        var flag = false;
        var msg = "存在しない従業員コードです";

        var tblData = document.getElementById("tbl");
        for (var i = 0, rowlen = tblData.rows.length; i < rowlen; i++) {
			if(tblData.rows[i].cells[0].innerText == form.emp_code.value){
				flag = true;
				break;
			}
		}

		if(!flag){
			alert(msg);
			return false;
		}
        msg = "この内容で保有資格を登録しますか？";
        var result = confirm(msg);
        return result;
    }

    window.onload = function(){
    	var date = new Date();

        var yyyy = date.getFullYear();
        var mm = ("0"+(date.getMonth()+1)).slice(-2);
        var dd = ("0"+date.getDate()).slice(-2);

    	document.getElementById("date").max=yyyy+'-'+mm+'-'+dd;
    }
</script>
</body>
</html>