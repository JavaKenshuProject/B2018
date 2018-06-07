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
<script>
    function check(){
        var form = document.forms.submitForm;
        var msg = "この内容で登録しますか？";
        var result = confirm(msg);
        return result;
    }
</script>
</head>
<body>
	<%@include file="anywhereHeader.jsp" %>
	<div>
	  <p class="all-title">従業員情報登録画面</p>
	  <h2>登録する従業員情報を入力してください</h2>
	  <br>
	  <hr><br>
		<form  name="submitForm" action="EmployeeRegistrationServlet" method="POST" onsubmit="return check();">
		  従業員コード：<input type="text" name="emp_code" required><br>
		  氏名（漢字）：<input type="text" name="l_name" placeholder="氏" required>
		  				<input type="text" name="f_name" placeholder="名" required><br>
		  氏名（フリガナ）：<input type="text" name="l_kana_name" placeholder="氏" required>
		  					<input type="text" name="f_kana_name" placeholder="名" required><br>
		  性別：<input type="radio" name="sex" value="0" checked="checked">男 <input type="radio" name="sex" value="1">女<br>
		  生年月日：<input type="date" name="birth_day" required><br>
		  所属部署名：<select name="section_code">
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


		  </select><br>
		  入社日：<input type="date" name="emp_date" required><br>
		  保有資格：<select name="license_code" required>
			<option>選択してください</option>

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

		  </select> <br>
		  <hr><br>
			<input type="submit" name="ACTION" value="登録">
			</form>
			<form action="menu.jsp" method="POST" >
			<input type="submit" value="キャンセル">
			</form>
	</div>
</body>
</html>