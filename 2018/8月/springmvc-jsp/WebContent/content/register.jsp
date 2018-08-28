<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>注册页面</h2>
<form:form modelAttribute="user" method="post" action="register">
	<table>
		<tr>
			<td>姓名：</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><form:input path="sex" /></td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><form:password path="password" showPassword="true" /></td>
		</tr>
		<tr>
			<td>文本：</td>
			<td><form:textarea path="" row="5" col="20" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>