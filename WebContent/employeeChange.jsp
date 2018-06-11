<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="employeeChangeError.jsp"%>
<%@page import="model.entity.EmployeeBean"
        import="model.entity.SectionBean"
        import="java.util.List"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>従業員情報変更</title>
			<link rel="stylesheet" href="employeeChange.css" type="text/css">
		</head>
		<body>
			<%@include file="anywhereHeader.jsp" %>
			<div>
			<p class="all-title">従業員情報変更</p>
			<%EmployeeBean emp = (EmployeeBean)session.getAttribute("employee"); %>
			変更したい箇所を編集してください

<table><tr><td class="td1">
			<form class="yoko" action="EmployeeChangeServlet" method="post" onsubmit="return check();">
				氏　名</td>
				<td class="td2">
				<input class="form" type="text" name = "l_name" placeholder="氏" maxlength="16" value="<%=emp.getlName() %>" required>
				<input class="form" type="text" name = "f_name" placeholder="名" maxlength="16" value="<%=emp.getfName() %>" required></td></tr>
				<tr><td class="td1">フリガナ</td><td class="td2">
				<input class="form" type="text" name="l_kana_name" placeholder="氏(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" value="<%=emp.getlKanaName() %>" required>
				<input class="form" type="text" name = "f_kana_name" placeholder="名(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" value="<%=emp.getfKanaName() %>" required></td></tr>
				<tr><td class="td1">性別</td><td class="td2"><input type="radio" value="0" name="sex" <%if(emp.getSex() == 0){%>checked<%} %>>男
					  <input type="radio" value="1" name="sex" <%if(emp.getSex() == 1){%>checked<%} %>>女</td></tr>

				<tr><td class="td1">所属部署名</td><td class="td2"><select name="section_code">
					<%List<SectionBean> sectionList = (List<SectionBean>)session.getAttribute("scList") ; %>
					<%for(SectionBean section: sectionList){%>
					<option value="<%=section.getSectionCode()%>" <%if(section.getSectionName().equals(emp.getSectionName())){%>selected<%}%>><%=section.getSectionName() %></option>
				<%} %>
				</select></td></tr></table>

			    <input class="button" type="submit" value="変更" name="ACTION">
			</form>

			<form class="yoko" action="employeeList.jsp">
				<input class="button" type="submit" value="キャンセル">
			</form>
			</div>
		</body>
			<script>
			    function check(){
			        var form = document.forms.submitForm;
			        var msg = "この内容で従業員情報を変更しますか？";
			        var result = confirm(msg);
			        return result;
			    }
		    </script>
	</html>