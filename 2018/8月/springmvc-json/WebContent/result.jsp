<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回json格式的数据</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		testResponseBody();
	});
	function testResponseBody(){
		$.post("${pageContext.request.contextPath}/json/testResponseBody",null,
				function(data){
			$.each(data,function(){
				var tr = $("<tr align='center' />");
				$("<td/>").html(this.id).appendTo(tr);
				$("<td/>").html(this.name).appendTo(tr);
				$("<td/>").html(this.author).appendTo(tr);
				$("#booktable").append(tr);
			})
		},"json");
	}
</script>
</head>
<body>
<table id="booktable" border="1" style="border-collapse: collapse;" >
	<tr align="center">
		<th>编号</th>
		<th>书名</th>
		<th>作者</th>
	</tr>
</table>
</body>
</html>