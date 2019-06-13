<html>

    <#include "../common/header.ftl" >

<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
        <#include "../common/nav.ftl" >

<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                    <#list orderDTOPage.content as orderDTO>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.userName}</td>
                        <td>${orderDTO.userPhone}</td>
                        <td>${orderDTO.userAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                        <td>${orderDTO.getPayStatusEnum().getMessage()}</td>
                        <td>${orderDTO.createTime}</td>
                        <td>
                            <a href="/dylxh/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                        </td>
                        <td>
                            <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                <a href="/dylxh/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                            </#if>
                        </td>
                        </td></td></tr>
                    </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/dylxh/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..orderDTOPage.getTotalPages() as index>
                        <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                    <li><a href="/dylxh/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte orderDTOPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/dylxh/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>


<div class="modal fade" id="mymodal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()"  type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>

    </div>

</div>


<audio id="notice" loop="loop">
    <source src="/dylxh/mp3/song.mp3" type="audio/mpeg"
</audio>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    var websocket = null;
    if ('websocket' in window) {
        websocket = new WebSocket('ws://dylxh.natapp1.cc/dylxh/webSocket');

        websocket.onopen = function (event) {
            console.log('connection link');
        };

        websocket.onclose = function (event) {
            console.log('connection disable');
        };

        websocket.onmessage = function (event) {
            console.log("receive message:" + event.data);

            //tip
            $('#mymodal').modal('show');

            document.getElementById('notice').play();
        };

        websocket.onerror = function () {
            alert('websocket error');
        };

        websocket.onbeforeunload = function(){
            websocket.close();
        };
    }
    else{
        alert('not support');
    }
</script>

</body>
</html>