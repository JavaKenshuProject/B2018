<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="userRegistrationError.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.SectionBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システム利用者追加</title>
<link rel="stylesheet" href="userRegistration.css" type="text/css">
</head>

<body>
	<%@include file="anywhereHeader.jsp"%>
	<div>


		<p class="all-title">システム利用者追加</p>
		追加したい従業員情報を入力してください
		<form class="yoko" name="submitForm" action="UserRegistrationServlet"
			method="POST" onsubmit="return check();">
			<table class="table1">
				<tr>
					<td class="td1">ユーザID<br>(半角英数字24文字以内)</td>
					<td class="td2"><input class="form" id="userID" type="text" name="user_id"
						pattern="^[a-zA-Z0-9]{0,24}$" required></td>
				</tr>
				<tr>
					<td class="td1">パスワード<br>(半角英数字32文字以内)</td>
					<td class="td2"><input class="form" id="pass" type="text" name="password"
						pattern="^[a-zA-Z0-9]{0,32}$" required></td>
				</tr>
				<tr>
					<td class="td1">所属部署</td>
					<td class="td2"><select name="section_code">
							<%
								List<SectionBean> sectionlist = (List<SectionBean>) session.getAttribute("sectionlist");

								if (sectionlist != null) {
									for (int i = 0; i < sectionlist.size(); i++) {
										SectionBean section = sectionlist.get(i);
							%>
							<option value="<%=section.getSectionCode()%>"><%=section.getSectionName()%></option>

							<%
								}
								}
							%>
					</select></td>
				</tr>
			</table>
			<table class="table2">
				<tr>
					<td><input class="submit" type="submit" name="ACTION"
						value="登録">
						</form></td>
					<td>
						<form class="yoko" action="menu.jsp" method="POST">
							<input class="submit" type="submit" value="キャンセル">
						</form>
					</td>
				</tr>
			</table>
	</div>

	<script>
		function check() {
			var form = document.forms.submitForm;
			var msg = "この内容でシステム利用者を登録しますか？";
			var result = confirm(msg);
			return result;
		}
	</script>
</body>
</html>