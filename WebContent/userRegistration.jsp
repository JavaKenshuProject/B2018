<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="userRegistrationError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.SectionBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システム利用者追加画面</title>
<link rel="stylesheet" href="ManagementSystem.css" type="text/css">
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
		<p>追加したい従業員情報を入力してください</p>

		<form name="submitForm" action="UserRegistrationServlet" method="POST" onsubmit="return check();">
		<p>&nbsp;&nbsp;&nbsp;ユーザID：<input id="userID" type="text" name="user_id" required></p>
		<p>パスワード：<input id="pass" type="password" name="password" required></p>
		所属部署：
		<select name="section_code">
		<option value="null">選択してください</option>
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
		</select>
			<p class="submit">
			<input type="submit" name="ACTION" value="登録">　　</form>
			<form action="menu.jsp" method="POST" >
			<input type="submit" value="キャンセル">
			</form>
			</p>
</div>

</body>
</html>