<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="changeLogError.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ChangeLogBean" %>

<!DOCTYPE html>
<html>
<head>
	<title>変更ログ一覧画面</title>
	<meta charset="UTF-8">
	<style>
	h1 {
		text-align: center;
	}
	div{
		text-align: center;
	}
	</style>
</head>
<body>

	<%@include file="anywhereHeader.jsp" %>
<h1>変更ログ一覧画面</h1>
<a href="menu.jsp"><input type="button" value="戻る"></a>
<hr>
<div style="height:300px; overflow-y:scroll;">
<%	List<ChangeLogBean> clList = (List<ChangeLogBean>)session.getAttribute("changeLogList");
	for(ChangeLogBean clBean: clList){ %>
	<%=clBean.getUpdateDate() %> &nbsp;<%=clBean.getSection() %>の<%=clBean.getUserId() %>が<%=clBean.getEmpCode() %>の従業員データを<%=clBean.getOperation() %>しました<br>
<% 	} %>
</div>
</body>
</html>