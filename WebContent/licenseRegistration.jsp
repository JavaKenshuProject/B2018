<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>保有資格登録画面</title>
</head>
<body>

<h1>従業員の保有資格の登録</h1>
従業員コード：<input type="text"><br>
資格名：
<form action="LicenseRegistrationServlet" method="POST">
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
取得日：<input type="text" placeholder="例：1994年3月4日→19940304"><br>
<br>
<br>
<input type="button" value="追加" name=Action>&nbsp;
</form>
<form action="menu.jsp" method="POST">
<input type="button" value="キャンセル">
</form>

</body>
</html>