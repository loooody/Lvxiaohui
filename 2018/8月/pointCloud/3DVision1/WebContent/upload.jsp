<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./style.css">
<script src="Vision3D.js" ></script>
<script type="text/javascript">
//文件传输成功后显示转换成功
window.onload=function(){
		document.getElementById("start").onclick = function(){
			var xhr = getXHR();
			xhr.onreadystatechange=function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					document.getElementById("submit").innerHTML = xhr.responseText;
				}
			}
			xhr.open("GET","display3Dvision");
			xhr.send();
		}
	}
	

</script>
<title>文件上传</title>

</head>

<body>
		
		<%
			request.setCharacterEncoding("gb2312");
			String message = (String)request.getAttribute("message");
			if(message != null && !"".equals(message)){	
		%>
		<script type="text/javascript">
			alert("<%= message %>");
		</script>
		<%} %>
<div class="container">
  <div class="header">
    <div class="logo">PotreeConverter-Online</div>
 		 </div>
  			<div class="content">
    			<div class="tip-platform">This is a platform which provides the free PotreeConverter service online.</div>
    			<div class="tip-upload">You can click the following button to upload your data files.</div>
   			 <div id="uploader" class="wu-example">
      			<!--用来存放文件信息-->
     			 <div id="thelist" class="uploader-list"></div>
     
     				<br />
      				<div class="btns">
        				
         				<form action="vision" enctype="multipart/form-data" method="post">
        					<!-- <input type="file"  name="filename" value=""/>-->
        					
        					<input type="file" name="filename" accept=".las,.laz" style="width:150px;height:50px;margin:0px 85px">
     							<br />
     						
	     					<input type="submit" id="sub" value="提交" style="width:120px;height:40px;margin:0px 85px">
	     					
     					 </form>
     					 <br /><br />
     					 <div id="start" style="width:300px;height:40px;overflow:hidden;margin-left:85px;">
     					<div style="width:120px;height:40px;float:left;">
     					<input type="button"  value="开始文件转换" style="width:120px;height:40px;"/></div>
     					<div id="submit" style="width:160px;height:40px;float:left;padding:10px;">未转换！！</div>
     				</div>
      			</div>
	      		<br />
	      <div class="btn1">
	      	
	      		<input type="button"  value="查看结果"
	      			onclick="window.location.href='display3Dvision2';" 
	      			style="width:120px;height:40px">
	      </div>
      </div>
    </div>
   </div>
</div>
</body>
</html>