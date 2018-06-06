<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href=".css" type="text/css" media="all" />
<meta name="author" content="Namioka Saki">
<meta charset="UTF-8">
<title>保有資格登録画面</title>
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
<h1>従業員の保有資格の登録</h1>
<form name="submitForm" action="LicenseRegistrationServlet" method="POST" onsubmit="return check();">
従業員コード：<input type="text" required><br>
資格名：
<select>
<option>ITパスポート</option>
<option>基本情報技術者試験</option>
<option>応用情報技術者試験</option>
<option>Oracle Master Bronze</option>
<option>Oracle Master Silver</option>
<option>Oracle Master Gold</option>
<option>OJC-P</option>
<option>OJC-WS</option>
<option>OCUP-F</option>
<option>OCUP-I</option>
<option>OCUP-A</option>
</select>
<br>
取得日：<input type="date" required><br>
<br>
<br>
<input type="submit" value="追加" name="ACTION">&nbsp;
</form>
<form action="menu.jsp" method="POST">
<input type="submit" value="キャンセル">
</form>

</body>
</html>