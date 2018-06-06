<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.entity.EmployeeBean"
    import="model.entity.SectionBean"
    import="java.util.List"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>従業員情報変更画面</title>
			<link rel="stylesheet" href="employeeChange.css" type="text/css">
		</head>
		<body>
			<%@include file="anywhereHeader.jsp" %>
			<div class="box">
			<h1>従業員情報変更</h1>
			<h2>現在の内容</h2>
			<%EmployeeBean emp = (EmployeeBean)session.getAttribute("employee"); %>
			氏名:
			<%=emp.getlName()%>
			<%=emp.getfName()%>　
			氏名(フリガナ)
			<%=emp.getlKanaName()%>
			<%=emp.getfKanaName()%>　
			性別:
			<%byte sex = emp.getSex(); %>
			<%if(sex == 0){ %>
			男
			<%}else if(sex == 1){%>
			女
			<%}%>　
			所属部署:
			<%=emp.getSectionName()%>

			<br>
			<hr>
			<br>
			<h2>変更内容</h2>
			<form action="EmployeeChangeServlet" method="post">
				氏　名　：<input type="text" name = "l_name" placeholder="氏"><input type="text" name = "f_name" placeholder="名"><br>
				フリガナ：<input type="text" name="l_kana_name" placeholder="氏">><input type="text" name = "f_kana_name" placeholder="名"><br>
				性別：<input type="radio" value="0" name="sex">男
					  <input type="radio"value="1" name="sex">女<br>
				所属部署名：<select name="section_code">
					<option>選択してください</option>
					<%List<SectionBean> sectionList = (List<SectionBean>)session.getAttribute("scList") ; %>
					<%for(SectionBean section: sectionList){%>
					<option value="<%=section.getSectionCode()%>"><%=section.getSectionName() %></option>
				<%} %>
				</select>
				<br>
				<hr>
				<br>
				<input type="submit" value="変更" name="ACTION"></form>

				<form action="employeeList.jsp">
				<input type="submit" value="キャンセル"></form>
			</div>
		</body>
	</html>