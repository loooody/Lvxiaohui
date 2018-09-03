<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!-- web路径
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出错
以/开始的相对路径，找资源，以服务器的路径为标准（http://localhost:3306）；需要加上项目名
 -->
 
<script src="${APP_PATH }/static/js/jquery-1.12.4.min.js" ></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-LOOOODY</h1>
			</div>
			
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 表格数据 -->
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>employee</th>
						<th>gender</th>
						<th>email</th>
						<th>deptName</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="emps_table">
				
				</tbody>
			</table>
		</div>
		<!-- 分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6">
				当前页，总页，总条记录
			</div>
			<!-- 分页信息 -->
			<div class="col-md-6">
				
			</div>
		</div>
	</div>
	
	<script>
		//1.页面加载完成后，直接取发送ajax请求，要到分页数据
		$(function(){
			$.ajax({
				url:"${APP_PATH}/emps",
				data:"pn=1",
				type:"GET",
				success:function(result){
					console.log(result);
					//1.解析并显示员工数据
					build_emps_table(result)
					//2.解析并显示分页信息
					
				}
			});
		});
		
		function build_emps_table(result){
			var emps = result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				// alert(item.empName);
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender=="M"?"男" : "女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>").append(item.department.deptName);
				
				
				/* <button class="btn btn-primary btn-sm ">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				编辑
				</button> */
				//添加按钮
				var editbtn = $("<button></button>").addClass("btn btn-primary btn-sm")
								.append("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑");
				//删除按钮
				var deletebtn = $("<button></button>").addClass("btn btn-danger btn-sm")
								.append("<span></span>").addClass("glyphicon glyphicon-trash").append("删除");
				var btnTd = $("<td></td>").append(editbtn).append(" ").append(deletebtn);
				$("<tr></tr>").append(empIdTd)
						.append(empNameTd)
						.append(genderTd)
						.append(emailTd)
						.append(deptNameTd)
						.append(btnTd)
						.appendTo("#emps_table"); 
			});
		}
	</script>
</body>
</html>