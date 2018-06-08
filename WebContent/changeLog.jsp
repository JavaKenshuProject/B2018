<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="changeLogError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ChangeLogBean" %>

<!DOCTYPE html>
<html>
<head>
	<title>情報の変更ログ</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="employeeRegistration.css" type="text/css">

</head>
<body>


	<%@include file="anywhereHeader.jsp" %>
<p class="all-title">情報の変更ログ</p>
<p style="text-align:center;"><a href="menu.jsp"><input class="submit" style="width:80px;height:40px; font-size:14px;" type="button" value="戻 る"></a></p>

<div style="height:300px; overflow-y:scroll;">
<%	List<ChangeLogBean> clList = (List<ChangeLogBean>)session.getAttribute("changeLogList");
	for(ChangeLogBean clBean: clList){ %>
	<%=clBean.getUpdateDate() %> &nbsp;<%=clBean.getSection() %>の<%=clBean.getUserId() %>が<%=clBean.getEmpCode() %>の従業員データを<%=clBean.getOperation() %>しました<br>
<% 	} %>
</div>
</body>
</html>