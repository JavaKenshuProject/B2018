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
<title>従業員一覧</title>
<link rel="stylesheet" href="employeeList.css" type="text/css">
<script type="text/javascript" src="jquery.min.js"></script>
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
		<table class="search">
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
				</select>
				</td>
				<td rowspan="2"><strong>　検索したい名前：</strong> <input type="text" name="name" value="<%if(name!=null){ %><%=name%><%}%>"></td>
				<td rowspan="2"><input type="submit" value="絞り込み" name="ACTION" class="button2">
				<button type="submit" value="従業員一覧" name="ACTION" class="button2">リセット</button></td>
			</tr>
			<tr>
				<td>
				<strong>並び替え：</strong> <select name="sort">
					<option value="emp_code" <%if ("emp_code".equals(sort)) {%>	selected <%}%>>従業員コード</option>
					<option value="emp_date" <%if ("emp_date".equals(sort)) {%>	selected <%}%>>入社日</option>
					<option value="birth_day" <%if ("birth_day".equals(sort)) {%>selected <%}%>>生年月日</option>
				</select>
				<input type="radio" name="order" value="ASC" <%if ("ASC".equals(order) || order==null) {%> checked <%}%>>昇順
				<input type="radio" name="order" value="DESC" <%if ("DESC".equals(order)) {%> checked <%}%>>降順
				</td>
			</tr>
		</table>
	</form>

	<form method="POST" name="submitForm">


	<%
		if (empList != null) {
	%>
	<div align="center">
	<div class="scrollList">
		<table class="list">
		<thead id="scrollHead">
			<tr>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<th class="select">選択</th>
				<%
					}
				%>
				<th class="code">従業員コード</th>
				<th class="name">氏名</th>
				<th class="hurigana">フリガナ</th>
				<th class="sex">性別</th>
				<th class="birthday">生年月日</th>
				<th class="section">部署</th>
				<th class="date">入社日</th>
				<th class="license">保有資格</th>
			</tr>
		</thead>
		<tbody id="scrollBody">
			<%
				for (EmployeeBean emp : empList) {
			%>
			<tr>
				<%
					if (user.getSectionCode().equals("S1")) {
				%>
				<td class="select"><input type="radio" name="target" value="<%=emp.getEmpCode()%>" required></td>
				<%
					}
				%>
				<td class="code"><%=emp.getEmpCode()%></td>
				<td class="name"><%=emp.getlName()%><%if(emp.getlName().length()+emp.getfName().length()>6){%><br><%}else{%>&thinsp;<%}%><%=emp.getfName()%></td>
				<td class="hurigana"><%=emp.getlKanaName()%><%if(emp.getlKanaName().length()+emp.getfKanaName().length()>=9){%><br><%}else{%>&thinsp;<%}%><%=emp.getfKanaName()%></td>
				<td class="sex">
					<%
						if (emp.getSex() == 0) {
					%> 男 <%
						} else if (emp.getSex() == 1) {
					%> 女 <%
						}
					%>
				</td>
				<td class="birthday"><%=emp.getBirthDay()%></td>
				<td class="section"><%=emp.getSectionName()%></td>
				<td class="date"><%=emp.getEmpDate()%></td>

				<td class="license">
				<% if(emp.getLicenseList().size()!=0){%>
					<div class="fukidiv">
						<span class="text"><%=emp.getLicenseList().size() %>個</span>
						<span class="fukidashi">
							<span class="fukititle"><%=emp.getlName()%><%=emp.getfName()%>さんの保有資格</span>
							<br>
							<ul>
							<%for(String code:emp.getLicenseList()){ %>
							<li><%=licenseMap.get(code) %></li>
							<%} %>
							</ul>
						</span>
					</div>
				<%}else{ %>
				なし
				<%} %>
				</td>

			</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</div>
	</div>
	<%
		} else {
	%>
	<p class="nonEmployee">条件に当てはまる従業員が存在しません</p>
	<%
		}
	%>

	<div class="buttonMenu">
	<a href="menu.jsp" class="back"><input type="button" value="メニューに戻る" class="button"></a>　　
	<%
		user = (UserBean)session.getAttribute("user");
		if (user.getSectionCode().equals("S1")) {
	%>
	<button type="submit" value="従業員情報変更" name="ACTION" onClick="form.action='EmployeeChangeServlet';return checkOnly()" class="button">従業員情報変更</button>　
	<button type="submit" value="従業員情報削除" name="ACTION" onClick="form.action='EmployeeDeleteServlet';return check()" class="button">従業員情報削除</button>
	<br>
	<span class="mess">従業員情報の変更や削除は、従業員を選択してからボタンを押してください。</span>
	</div>
	<%
		}
	%>
	</form>
<script>
	function check(){
		var form = document.forms.submitForm;
		//チェックされているかの判定
		var flag = false;
		for(var i=0;i<form.target.length;i++){
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
		for(var i=0;i<form.target.length;i++){
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
	$(function(){
	  $("table.list tbody tr:nth-child(even)").addClass("even");
	  $("table.list tbody tr").mouseover(function(){
	    $(this).addClass("hover");
	  }).mouseout(function(){
	    $(this).removeClass("hover");
	  });
	});
</script>
</body>
</html>