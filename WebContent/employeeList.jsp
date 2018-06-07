<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="employeeListError.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="model.entity.EmployeeBean"%>
<%@ page import="model.entity.SectionBean"%>
<%@ page import="model.entity.UserBean"%>
<%@ page import="model.entity.LicenseBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員一覧画面</title>
<link rel="stylesheet" href="ManagementSystem.css" type="text/css">
<style>
div table {
	border: 1px solid black;
}

th {
	border: 1px solid black;
}

div td {
	border: 1px solid black;
}

form {
	display: inline;
}
.baloonoya{
	position: relative;
	cursor: pointer;
}
</style>
</head>
<body>
	<%@include file="anywhereHeader.jsp"%>
	<%
		String initial = (String)session.getAttribute("initial");
		String sectionName = (String)session.getAttribute("section_name");
		String sex = (String)session.getAttribute("sex");
		String sort = (String)session.getAttribute("sort");
		String order = (String)session.getAttribute("order");
		String name = (String)session.getAttribute("name");
		List<EmployeeBean> empList = (List<EmployeeBean>) session.getAttribute("empList");
		Map<String, String> licenseMap = (Map<String, String>)session.getAttribute("licenseMap");
	%>
	<p class="all-title">従業員一覧</p>
	<form action="EmployeeListServlet" method="POST">
		<table>
			<tr>
				<td><strong>絞り込み：</strong>
				頭文字
				<select name="initial">
					<option value="">指定なし</option>
					<option value="ア" <%if ("ア".equals(initial)) {%> selected <%}%>>ア行</option>
					<option value="カ" <%if ("カ".equals(initial)) {%> selected <%}%>>カ行</option>
					<option value="サ" <%if ("サ".equals(initial)) {%> selected <%}%>>サ行</option>
					<option value="タ" <%if ("タ".equals(initial)) {%> selected <%}%>>タ行</option>
					<option value="ナ" <%if ("ナ".equals(initial)) {%> selected <%}%>>ナ行</option>
					<option value="ハ" <%if ("ハ".equals(initial)) {%> selected <%}%>>ハ行</option>
					<option value="マ" <%if ("マ".equals(initial)) {%> selected <%}%>>マ行</option>
					<option value="ヤ" <%if ("ヤ".equals(initial)) {%> selected <%}%>>ヤ行</option>
					<option value="ラ" <%if ("ラ".equals(initial)) {%> selected <%}%>>ラ行</option>
					<option value="ワ" <%if ("ワ".equals(initial)) {%> selected <%}%>>ワ行</option>
				</select> &nbsp;
				部署
				<select name="section_name">
					<option value="">指定なし</option>
					<%
						List<SectionBean> secList = (List<SectionBean>) session.getAttribute("sectionList");
						for (SectionBean section : secList) {
					%>
					<option value=<%=section.getSectionName()%> <%if (section.getSectionName().equals(sectionName)) {%> selected<%}%>><%=section.getSectionName()%></option>
					<%
						}
					%>
				</select> &nbsp;
				性別
				<select name="sex">
					<option value="-1">指定なし</option>
					<option value="0" <%if ("0".equals(sex)) {%> selected <%}%>>男</option>
					<option value="1" <%if ("1".equals(sex)) {%> selected <%}%>>女</option>
				</select> <br> <strong>並び替え：</strong> <select name="sort">
					<option value="emp_code" <%if ("emp_code".equals(sort)) {%>	selected <%}%>>従業員コード</option>
					<option value="emp_date" <%if ("emp_date".equals(sort)) {%>	selected <%}%>>入社日</option>
					<option value="birth_day" <%if ("birth_day".equals(sort)) {%>selected <%}%>>生年月日</option>
				</select>
				<input type="radio" name="order" value="ASC" <%if ("ASC".equals(order) || order==null) {%> checked <%}%>>昇順
				<input type="radio" name="order" value="DESC" <%if ("DESC".equals(order)) {%> checked <%}%>>降順
				</td>
				<td><strong>検索したい名前：</strong> <input type="text" name="name" value="<%if(name!=null){ %><%=name%><%}%>"></td>
				<td><input type="submit" value="絞り込み" name="ACTION"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="menu.jsp"><input type="button" value="メニューに戻る"></a>
	<%
		user = (UserBean)session.getAttribute("user");
		if (user.getSectionCode().equals("S1")) {
	%>
	従業員情報の変更や削除は、従業員を選択してからボタンを押してください。
	<form method="POST" name="submitForm">
	<hr>
	<%
		}
	%>

	<%
		if (empList != null) {
	%>
	<div style="height: 320px; overflow-y: scroll;">
		<table>
			<tr>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<th>選択</th>
				<%
					}
				%>
				<th>従業員コード</th>
				<th>氏名</th>
				<th>フリガナ</th>
				<th>性別</th>
				<th>生年月日</th>
				<th>部署</th>
				<th>入社日</th>
				<th>保有資格</th>
			</tr>
			<%
				for (EmployeeBean emp : empList) {
			%>
			<tr>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<td><input type="radio" name="target" value="<%=emp.getEmpCode()%>" required></td>
				<%
					}
				%>
				<td><%=emp.getEmpCode()%></td>
				<td><%=emp.getlName()%><%=emp.getfName()%></td>
				<td><%=emp.getlKanaName()%><%=emp.getfKanaName()%></td>
				<td>
					<%
						if (emp.getSex() == 0) {
					%> 男 <%
						} else if (emp.getSex() == 1) {
					%> 女 <%
						}
					%>
				</td>
				<td><%=emp.getBirthDay()%></td>
				<td><%=emp.getSectionName()%></td>
				<td><%=emp.getEmpDate()%></td>

				<td class="baloonoya"><%=emp.getLicenseList().size() %></td>

			</tr>
			<%
				}
			%>
		</table>
	</div>
	<%
		if (user.getSectionCode().equals("S1")) {
	%>
	<button type="submit" value="従業員情報変更" name="ACTION" onClick="form.action='EmployeeChangeServlet';return true">従業員情報変更</button> &nbsp;
	<button type="submit" value="従業員情報削除" name="ACTION" onClick="form.action='EmployeeDeleteServlet';return check()">従業員情報削除</button>
	<%	} %>
	<%
		} else {
	%>
	<h2>条件に当てはまる従業員が存在しません</h2>
	<%
		}
	%>
	</form>
<script>
	function check(){
		var form = document.forms.submitForm;
		//チェックされているかの判定
		var flag = false;
		for(var i=0;i<form.target.length-1;i++){
			if(form.target[i].checked){
				flag = true;
			}
		}
		if(!flag){
			alert("従業員を選択してください");
			return false;
		}
		//確認
		var msg = "選択した従業員を削除してもよろしいですか？";
		var result = confirm(msg);
		return result;
	}
	function checkOnly(){
		var form = document.forms.submitForm;
		//チェックされているかの判定
		var flag = false;
		for(var i=0;i<form.target.length-1;i++){
			if(form.target[i].checked){
				flag = true;
			}
		}
		if(!flag){
			alert("従業員を選択してください");
			return false;
		}
		return true;
	}
</script>
</body>
</html>