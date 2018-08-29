<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loooody</title>
</head>
<body>
	<h3>表单数据格式化</h3>
	<br>
	<form:form modelAttribute="user" action="" method="post">
		<table>
			<tr>
				<td><label>日期类型:</label></td>
				<td><form:input path="birthday" /></td>
			</tr>
			<tr>
			<td><label>整数类型:</label></td>
			<td><form:input path="total" /></td>
			</tr>
			<tr>
			<td><label>百分数类型:</label></td>
			<td><form:input path="discount" /></td>
			</tr>
			<tr>
			<td><label>货币类型:</label></td>
			<td><form:input path="money" /></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="提	交"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>