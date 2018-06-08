<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="employeeRegistrationError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.SectionBean" %>
<%@ page import="model.entity.LicenseBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報登録画面</title>
<link rel="stylesheet" href="employeeRegistration.css" type="text/css">
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
	<div>
	  <p class="all-title">従業員情報登録画面</p>
	  登録する従業員情報を入力してください
	  <br>
	  <hr>
	  <table class="table1">
		 <form class="yoko" name="submitForm" action="EmployeeRegistrationServlet" method="POST" onsubmit="return check();">
		<tr> <td class="td1">従業員コード<br>（E***の形式 例：E001）</td><td class="td1"><input class="form" type="text" name="emp_code"  pattern="^E[0-9]{3}$" maxlength="4" required></td></tr>
		  <tr><td class="td1">氏　名</td><td class="td1"><input class="form" type="text" name="l_name" placeholder="氏" maxlength="16" required>
		  		<input class="form" type="text" name="f_name" placeholder="名" maxlength="16" required></td></tr>
		  <tr><td class="td1">氏名（全角カタカナ）</td><td class="td1"><input class="form" type="text" name="l_kana_name" placeholder="氏(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" required>
		  					<input class="form" type="text" name="f_kana_name" placeholder="名(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" required></td></tr>
		 <tr><td class="td1">性　別</td><td class="td1"><input type="radio" name="sex" value="0" checked="checked">男 　　　<input type="radio" name="sex" value="1">女</td></tr>
		 <tr><td class="td1">生年月日</td><td class="td1"><input class="form" type="date" id="date" name="birth_day" min="0000-01-01" required></td></tr>
		  <tr><td class="td1">所属部署名</td><td class="td1"><select class="select" name="section_code">
		    <%

		    List<SectionBean> sectionlist = (List<SectionBean>)session.getAttribute("sectionlist");

		    if(sectionlist != null){
		    	for(int i = 0; i < sectionlist.size(); i++) {
                    SectionBean section = sectionlist.get(i);
			%>
            <option value="<%= section.getSectionCode() %>"><%= section.getSectionName() %></option>

            <%
		    	}
		    }
            %>


		  </select></td></tr>
		 <tr><td class="td1">入社日</td><td class="td1"><input class="form" type="date" id="date2" name="emp_date" min="0000-01-01" required></td></tr>
		  <tr><td class="td1">保有資格</td><td class="td1"><select class="select" name="license_code">
		  	<option value="">未選択</option>
		 	<%

		 	List<LicenseBean> licenselist = (List<LicenseBean>)session.getAttribute("licenselist");

		 	if(licenselist != null){
		    	for(int i = 0; i < licenselist.size(); i++) {
                    LicenseBean license = licenselist.get(i);
			%>
			<option value="<%= license.getLicenseCode() %>"><%= license.getLicenseName() %></option>

			<%
		    	}
		 	}
            %>

		  </select></td></tr>
			<table class="table2"><tr><td><input class="submit" type="submit" name="ACTION" value="登録"></td>
			</form><td>
			<form class="yoko" action="menu.jsp" method="POST" >
			<input class="submit" type="submit" value="キャンセル">
			</form></td></tr></table>
	</div>


<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で従業員情報を登録しますか？";
        var result = confirm(msg);
        return result;
    }

    window.onload = function(){
    	var date = new Date();

        var yyyy = date.getFullYear();
        var mm = ("0"+(date.getMonth()+1)).slice(-2);
        var dd = ("0"+date.getDate()).slice(-2);

    	document.getElementById("date").max=yyyy+'-'+mm+'-'+dd;
    	document.getElementById("date2").max=yyyy+'-'+mm+'-'+dd;
    }
</script>
</body>
</html>