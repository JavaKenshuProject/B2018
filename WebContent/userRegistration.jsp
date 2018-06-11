<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="userRegistrationError.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.SectionBean"%>
<%@ page import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システム利用者追加</title>
<link rel="stylesheet" href="userRegistration.css" type="text/css">
</head>

<body>
	<%@include file="anywhereHeader.jsp"%>
	<% UserBean userBean = (UserBean)session.getAttribute("userBean"); %>
	<% List<UserBean> userList = (List<UserBean>)session.getAttribute("userlist");%>
	<div>


		<p class="all-title">システム利用者追加</p>
		追加したいシステム利用者情報を入力してください

		<form class="yoko" name="submitForm" action="UserRegistrationServlet"
			method="POST" onsubmit="return check();">
			<table class="table1">
				<tr><td><span class="red">※</span>必須項目です</td></tr>
				<tr>
					<td class="td1">ユーザID<span class="red">※</span><br>(半角英数字24文字以内)</td>
					<td class="td2"><input class="form" id="userID" type="text" name="user_id"
						pattern="^[a-zA-Z0-9]{0,24}$" value="<%if(userBean!=null){ %><%=userBean.getUserId() %><%} %>" required></td>
				</tr>
				<tr>
					<td class="td1">パスワード<span class="red">※</span><br>(半角英数字32文字以内)</td>
					<td class="td2"><input class="form" id="pass" type="text" name="password"
						pattern="^[a-zA-Z0-9]{0,32}$" value="<%if(userBean!=null){ %><%=userBean.getPassword() %><%} %>" required></td>
				</tr>
				<tr>
					<td class="td1">所属部署<span class="red">※</span></td>
					<td class="td2"><select name="section_code">
							<%
								List<SectionBean> sectionlist = (List<SectionBean>) session.getAttribute("sectionlist");

								if (sectionlist != null) {
									for (int i = 0; i < sectionlist.size(); i++) {
										SectionBean section = sectionlist.get(i);
							%>
							<option value="<%=section.getSectionCode()%>" <%if(userBean!=null && section.getSectionCode().equals(userBean.getSectionCode())){ %>selected<%} %>><%=section.getSectionName()%></option>

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
	<table id="tbl" style="display:none;">
	<%for(UserBean bean:userList){ %>
		<tr>
		<td><%=bean.getUserId() %></td>
		</tr>
	<%} %>
	</table>

	<script>
		function check() {
			var form = document.forms.submitForm;
			var flag = false;
	        var msg = "";

	        var tblData = document.getElementById("tbl");
	        for (var i = 0, rowlen = tblData.rows.length; i < rowlen; i++) {
				if(tblData.rows[i].cells[0].innerText == form.user_id.value){
					flag = true;
					msg = "既に登録されているユーザIDです"
					break;
				}
			}

			if(flag){
				alert(msg);
				return false;
			}
			msg = "この内容でシステム利用者を登録しますか？";
			var result = confirm(msg);
			return result;
		}
	</script>
</body>
</html>