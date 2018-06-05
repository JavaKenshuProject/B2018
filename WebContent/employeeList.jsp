<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="employeeListError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.EmployeeBean" %>
<%@ page import="model.entity.SectionBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>従業員一覧画面</title>
	<style>
	div table{
		border:1px solid black;
	}
	th{
		border:1px solid black;
	}
	div td{
		border:1px solid black;
	}
	</style>
	<script>
	<% %>
	</script>
</head>
<body>
<h1>従業員一覧画面</h1>
<h3>従業員情報の変更や削除は、従業員を選択してからボタンを押してください。</h3>
<form action="EmployeeChangeServlet" method="POST">
<input type="button" value="変更">
</form>
<form action="EmployeeDeleteServlet" method="POST">
<input type="button" value="削除">
</form>
<hr>
<form action="EmployeeListServlet" method="POST">
<table>
<tr>
<td>
<strong>絞り込み：</strong>
頭文字
<select name="initial">
	<option value="">指定なし</option>
	<option value="ア">ア</option>
	<option value="カ">カ</option>
	<option value="サ">サ</option>
	<option value="タ">タ</option>
	<option value="ナ">ナ</option>
	<option value="ハ">ハ</option>
	<option value="マ">マ</option>
	<option value="ヤ">ヤ</option>
	<option value="ラ">ラ</option>
	<option value="ワ">ワ</option>
</select>
&nbsp;
部署
<select name="section_name">
<option value="">指定なし</option>
<% 	List<SectionBean> secList = (List<SectionBean>)session.getAttribute("sectionList");
	for(SectionBean section: secList){%>
		<option value=<%=section.getSectionCode() %>><%=section.getSectionName() %></option>
<% 	} %>
</select>
&nbsp;
性別
<select name="sex">
<option value="0">指定なし</option>
<option value="1">男</option>
<option value="2">女</option>
</select>
<br>
<strong>並び替え：</strong>
<select name="sort">
<option value="emp_code">従業員コード</option>
<option value="emp_date">入社日</option>
<option value="birth_day">生年月日</option>
</select>
<input type="radio" name="order" value="ASC" checked="checked">昇順
<input type="radio" name="order" value="DESC">降順
</td>
<td>
<strong>検索したい名前：</strong>
<input type="text" name="name">
</td>
<td>
<input type="submit" value="絞り込み" name="ACTION">
</td>
</tr>
</table>
</form>
<hr>
<a href="menu.jsp"><input type="button" value="戻る"></a>
<hr>
<% 	List<EmployeeBean> empList = (List<EmployeeBean>)session.getAttribute("empList");%>
<% if(empList != null){ %>
<div style="height:300px; overflow-y:scroll;">
<table>
<tr><th>選択</th><th>従業員コード</th><th>氏名</th><th>フリガナ</th><th>性別</th><th>生年月日</th><th>部署</th><th>入社日</th><th>保有資格</th></tr>
<%
	for(EmployeeBean emp: empList){
	%>
<tr>
	<td><input type="radio" name="target"></td>
	<td><%=emp.getEmpCode() %></td>
	<td><%=emp.getlName() %><%=emp.getfName() %></td>
	<td><%=emp.getlKanaName() %><%=emp.getfKanaName() %></td>
	<td><% if(emp.getSex() == 0){ %>
		男
		<% }else if(emp.getSex() == 1){ %>
		女
		<% } %>
	</td>
	<td><%=emp.getBirthDay() %></td>
	<td><%=emp.getSectionName() %></td>
	<td><%=emp.getEmpDate() %></td>
	<td>一旦なし</td>
</tr>
<% } %>
</table>
</div>
<% }else{ %>
<h2>条件に当てはまる従業員が存在しません</h2>
<% } %>
</body>
</html>