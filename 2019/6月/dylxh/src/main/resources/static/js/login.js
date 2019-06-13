$(document).ready(function(){
	$("#login").click(function(event) {
		var name = $("#username").val();
		var pwd = $("#password").val();
		if(name=="")
		{
		   alert("用户名不能为空！");
		}
		else if(pwd=="")
		{
		   alert("密码不能为空！");
		}
		else if(pwd!="" && pwd.length < 6){
			alert("密码不能小于6位！");
		}
		$.ajax({
			url:"/dylxh/seller/login",
			data:"username=" + name,
			type:"post",
            success: function (data) {
                console.log(data);
                if (data.password == "123456") {
                    window.location = "/dylxh/seller/order/list";
                }else{
                    alert("没有此用户");
				}
            }
		});
	});

    $("#reset").click(function(event) {
        $("#username").val("");
        $("#password").val("");
    });
});