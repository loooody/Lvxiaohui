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
<!-- 员工修改模态框-->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" >员工修改</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label  class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			    	<p class="form-control-static" id="empName_update_static">email@example.com</p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label  class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="email" name="email" class="form-control" id="email_update_input" placeholder="email@loooody.com">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
				  <label  class="col-sm-2 control-label">gender</label>
				    <div class="col-sm-10">
				    <label class="radio-inline">
					  <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
				  <label  class="col-sm-2 control-label">department</label>
				   <div class="col-sm-4">
				    	<!-- 部门提交部门即可 -->
				    <select class="form-control" name="deptId"></select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="emp_update_btn">Update</button>
	      </div>
	    </div>
	  </div>
	</div> 


	<!-- 员工新增模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label  class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label  class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="email" name="email" class="form-control" id="email_add_input" placeholder="email@loooody.com">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
				  <label  class="col-sm-2 control-label">gender</label>
				    <div class="col-sm-10">
				    <label class="radio-inline">
					  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
				  <label  class="col-sm-2 control-label">department</label>
				   <div class="col-sm-4">
				    	<!-- 部门提交部门即可 -->
				    <select class="form-control" name="deptId"></select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="emp_save_btn">Save</button>
	      </div>
	    </div>
	  </div>
	</div> 

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
				<button class="btn btn-primary" id="emp_add_model_btn">新增</button>
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
			<div class="col-md-6" id="page_info_area">
				
			</div>
			<!-- 分页信息 -->
			<div class="col-md-6" id="page_info_nav">
				
			</div>
		</div>
	</div>
	
	<script>
	    //数据总记录数
	    var totalRecord,currentPage;
		//1.页面加载完成后，直接取发送ajax请求，要到分页数据
		$(function(){
			//去首页
			to_page(1);
		});
		
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/emps",
				data:"pn=" + pn,
				type:"GET",
				success:function(result){
					console.log(result);
					//1.解析并显示员工数据
					build_emps_table(result);
					//2.解析并显示分页信息
					build_page_info(result);
					//显示分页条
					build_page_nav(result);
				}
			});
		}
		
		function build_emps_table(result){
			//清空数据
			$("#emps_table").empty();
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
				var editbtn = $("<button></button>").addClass("btn btn-primary btn-sm update_btn")
								.append("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前员工的id
				editbtn.attr("edit-id",item.empId);
				//删除按钮
				var deletebtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
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
		
		//解析显示分页信息
		function build_page_info(result){
			//清空数据
			$("#page_info_area").empty();
			$("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总"+result.extend.pageInfo.pages
					+ "页，总" + result.extend.pageInfo.total + "条记录");
			
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		
		//分页信息
		function build_page_nav(result){
			//清空数据
			$("#page_info_nav").empty();
			//page_info_nav
			var ul = $("<ul></ul>").addClass("pagination");
			
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}
			else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum -1);
				});
			}
			
			//构建元素
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}
			else{
				//为元素添加点击翻页的事件
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			//1，2，3遍历给ul添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul添加到nav
			var navUl = $("<nav></nav>").append(ul);
			navUl.appendTo("#page_info_nav");
		}
		
		//表单完整重置方法
		function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		//点击新增按钮，弹出模态框
		 $("#emp_add_model_btn").click(function(){
			 //每次弹出模态框都清空表单(表单完整重置)
			 reset_form("#empAddModal form");
			// $("#empAddModal form")[0].reset();
			 //发送ajax请求，查出部门信息，显示在下拉列表中
			 getDepts("#empAddModal select");
			 
			 //弹出模态框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		}); 
		
		//查出所有部门信息并显示在下拉列表中
		function getDepts(ele){
			//清空列表
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
				//	console.log(result);
				$.each(result.extend.depts,function(){
					var optionEl = $("<option></option>").append(this.deptName).attr("value",this.deptId);
					optionEl.appendTo(ele);
				})
				}
			});
		}
		
		//校验表单数据
		function validate_add_form(){
			//1.拿到表单数据
			var empName = $("#empName_add_input").val();
			var regName = 	/(^[a-z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
			//	alert("用户名可是2-5位中文或者6-16位英文和数字的组合");
				//清空这个元素之前的元素
				show_validate_msg("#empName_add_input","error","用户名必须是2-5位中文或者6-16位英文和数字的组合");
				
				return false;
			}else{
				show_validate_msg("#empName_add_input","success","");
			};
			
			//校验邮箱信息
			var email = $("#email_add_input").val();
			var regEmail = 	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
			//	alert("邮箱有误，请重新输入");
				show_validate_msg("#email_add_input","error","邮箱有误，请重新输入");
				
				return false;
			}else{
				show_validate_msg("#email_add_input","success","");
			}
			
			return true;
		}
		
		//在模态框上显示校验信息
		function show_validate_msg(ele,status,msg){
			//清楚当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text(msg);
			if("success" == status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		$("#empName_add_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var empName = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName=" + empName,
				type:"POST",
				success:function(result){
					if(result.code == 200){
						show_validate_msg("#empName_add_input","success","用户名可用");
						$("#emp_save_btn").attr("ajax-va","success");
					}else{
						show_validate_msg("#empName_add_input","error",result.extend.va_msg);
						$("#emp_save_btn").attr("ajax-va","fail");
					}
				}
			});
		});
		
		$("#emp_save_btn").click(function(){
			//1.模态框中填写的表单数据提交给服务器进行保存
			//1.对要提交给服务器的数据进行校验
			 if(!validate_add_form()){
				return false;
			}  
			if($(this).attr("ajax-va") == "fail"){
				return false;
			}
			//发送ajax请求给服务器
		//	alert($("#empAddModal form").serialize());
			 $.ajax({
				url:"${APP_PATH}/emps",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					if(result.code == 200){
						//员工保存成功
						//1.关闭模态框
						$("#empAddModal").modal('hide');
						//2.来到最后一页
						to_page(totalRecord);
					}
					else{
						//显示失败信息
						console.log(result);
						//有哪个字段的错误信息就显示哪个字段的
						if(undefined != result.extend.emp_error.email){
							//显示邮箱错误信息
							show_validate_msg("#email_add_input","error",result.extend.emp_error.email);
						}
						if(undefined != result.extend.emp_error.empName){
							//显示员工姓名错误信息
							show_validate_msg("#empName_add_input","error",result.extend.emp_error.empName);
						}
					}
					
				}
				
			}) ;
		});
		
		//1.我们是按钮创建之前就绑定了click，所以绑定不上
		//1).可以在创建按钮的时候绑定  2）。绑定点击.live()
		//jquery新版没有live()方法，用on()来替代
		$(document).on("click",".update_btn",function(){
			//alert("点击成功");
			//1.查出员工信息
			getEmp($(this).attr("edit-id"));
			
			//2.查出部门信息，并显示部门列表
			
			getDepts("#empUpdateModal select")
			
			//把员工的id传递给模态框的更新按钮
			$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
			
			 //弹出模态框
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		});
		
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emps/" + id,
				type:"GET",
				success:function(result){
					//	console.log(result);
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.department.deptId]);
			//		console.log(result);
				}
			}); 
		}
		
		
		//点击更新，更新员工信息
		$("#emp_update_btn").click(function(){
			//验证邮箱是否合法
			//校验邮箱信息
			var email = $("#email_update_input").val();
			var regEmail = 	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
			//	alert("邮箱有误，请重新输入");
				show_validate_msg("#email_update_input","error","邮箱有误，请重新输入");
				
				return false;
			}else{
				show_validate_msg("#email_update_input","success","");
			}
			
			//发送ajax请求更新员工数据
			$.ajax({
				url:"${APP_PATH}/emps/" + $(this).attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//1.关闭对话框
					$("#empUpdateModal").modal("hide");
					//2.回到本页面
					to_page(currentPage);
				}
				
			});
		});
	</script>
</body>
</html>