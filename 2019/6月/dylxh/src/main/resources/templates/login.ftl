<html>
<head>
    <meta charset="UTF-8">
    <title>卖家后端系统</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body>
<div class="box">
    <div class="login-box">
        <div class="login-title text-center">
            <h1>
                <small>卖家管理系统</small>
            </h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form id="modifyPassword" class="form-horizontal" action="/dylxh/seller/order/list" method="post">
                    <!-- 用户名输入 -->
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
									<span class="input-group-addon"><span
                                            class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="username" name="username" class="form-control" placeholder="用户名" value="admin">
                            </div>
                        </div>
                    </div>

                    <!-- 密码输入 -->
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
									<span class="input-group-addon"><span
                                            class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="password" name="password" class="form-control" placeholder="密码" value="123456">
                            </div>
                        </div>
                    </div>

                    <br />

                    <!-- 登录重置按钮 -->
                    <div class="form-group form-actions">
                        <div class="col-xs-12 text-center">
                            <button type="button" id="login" class="btn btn-sm btn-success" >
                                <span class="fa fa-check-circle"></span>登录
                            </button>
                            <button type="button" id="reset" class="btn btn-sm btn-danger">
                                <span class="fa fa-close"></span> 重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</html>