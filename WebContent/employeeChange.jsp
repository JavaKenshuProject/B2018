<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="employeeChangeError.jsp"%>
<%@page import="model.entity.EmployeeBean"
        import="model.entity.SectionBean"
        import="java.util.List"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>従業員情報変更画面</title>
			<link rel="stylesheet" href="employeeChange.css" type="text/css">
			<script>
			    function check(){
			        var form = document.forms.submitForm;
			        var msg = "この内容で従業員情報を変更しますか？";
			        var result = confirm(msg);
			        return result;
			    }
		    </script>
		</head>
		<body>
			<%@include file="anywhereHeader.jsp" %>
			<div class="box">
			<h1>従業員情報変更</h1>
			<%EmployeeBean emp = (EmployeeBean)session.getAttribute("employee"); %>
			<hr>
			<br>
			<h2>変更内容</h2>
			<h3>変更したい箇所を編集してください</h3>
			<form action="EmployeeChangeServlet" method="post" onsubmit="return check();">
				氏　名&nbsp;&nbsp;&nbsp;：
				<input type="text" name = "l_name" placeholder="氏" maxlength="16" value="<%=emp.getlName() %>" required>
				<input type="text" name = "f_name" placeholder="名" maxlength="16" value="<%=emp.getfName() %>" required><br>
				フリガナ：
				<input type="text" name="l_kana_name" placeholder="氏(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" value="<%=emp.getlKanaName() %>" required>
				<input type="text" name = "f_kana_name" placeholder="名(フリガナ)" maxlength="24" pattern="^[ア-ン゛゜ァ-ォャ-ョー「」、]+$" value="<%=emp.getfKanaName() %>" required><br><br>
				性別：<input type="radio" value="0" name="sex" <%if(emp.getSex() == 0){%>checked<%} %>>男
					  <input type="radio" value="1" name="sex" <%if(emp.getSex() == 1){%>checked<%} %>>女<br>
				所属部署名：<select name="section_code">
					<option>選択してください</option>
					<%List<SectionBean> sectionList = (List<SectionBean>)session.getAttribute("scList") ; %>
					<%for(SectionBean section: sectionList){%>
					<option value="<%=section.getSectionCode()%>" <%if(section.getSectionName().equals(emp.getSectionName())){%>selected<%}%>><%=section.getSectionName() %></option>
				<%} %>
				</select>
				<br>
				<hr>
				<br>
			    <input type="submit" value="変更" name="ACTION">
			</form>

			<form class="yoko" action="employeeList.jsp">
				<input type="submit" value="キャンセル">
			</form>
			</div>
		</body>
	</html>