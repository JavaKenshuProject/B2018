<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="userRegistrationError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.SectionBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システム利用者追加画面</title>
<link rel="Stylesheet" href="userRegistration.css" type="text/css" media="all" />
</head>

<body>
<div>
		<p class ="title">システム利用者追加</p>
		<p>追加したい従業員情報を入力してください</p>
		<form action="UserRegistrationServlet" method="POST">
		<p>&nbsp;&nbsp;&nbsp;ユーザID：<input id="userID" type="text" name="user_id"></p>
		<p>パスワード：<input id="pass" type="password" name="password"></p>
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
			<input type="submit" name="action" value="登録">　　
			<input type="submit" name="action" value="キャンセル">
			</p>
	</form>
</div>

</body>
</html>