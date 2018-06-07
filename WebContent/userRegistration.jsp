<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="userRegistrationError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.SectionBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システム利用者追加画面</title>
<link rel="stylesheet" href="userRegistration.css" type="text/css">
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
		<p class="all-title">システム利用者追加</p>
		追加したい従業員情報を入力してください
		<hr>
		<br>
		<form class ="yoko" name="submitForm" action="UserRegistrationServlet" method="POST" onsubmit="return check();">
		<p>&nbsp;&nbsp;&nbsp;ユーザID(半角英数字24文字以内)：<input id="userID" type="text" name="user_id" pattern="^[a-zA-Z0-9]{0,24}$" required></p>
		<p>パスワード(半角英数字32文字以内)：<input id="pass" type="text" name="password" pattern="^[a-zA-Z0-9]{0,32}$" required></p>
		<p>所属部署：
		<select name="section_code">
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
		</select></p>
			<input class="submit" type="submit" name="ACTION" value="登録"></form>
			<form class="yoko" action="menu.jsp" method="POST" >
			<input class="submit" type="submit" value="キャンセル">
			</form>
</div>

</body>
</html>