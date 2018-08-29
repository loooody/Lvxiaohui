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
	<h3>测试JSR 303</h3>
	<br>
	<form:form modelAttribute="user"  method="post" action="login">
		<table>
			<tr>
				<td><label>登录名:</label></td>
				<td><form:input path="loginname" /></td>
				<td><form:errors path="loginname" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>密	码:</label></td>
			<td><form:input path="password" /></td>
			<td><form:errors path="password" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>用户名:</label></td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>年	龄:</label></td>
			<td><form:input path="age" /></td>
			<td><form:errors path="age" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>邮	箱:</label></td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>生	日:</label></td>
			<td><form:input path="birthday" /></td>
			<td><form:errors path="birthday" cssStyle="color:red" /></td>
			</tr>
			<tr>
			<td><label>电	话:</label></td>
			<td><form:input path="phone" /></td>
			<td><form:errors path="phone" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="提	交"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>