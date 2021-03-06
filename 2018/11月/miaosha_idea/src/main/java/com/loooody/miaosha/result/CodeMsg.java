package com.loooody.miaosha.result;

public class CodeMsg {
    private int code;
    private String msg;

    //登录模块
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "server_error");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500101, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500102, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500103, "手机号错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500104, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500105, "密码错误");
    public static CodeMsg BIND_ERROR = new CodeMsg(500106, "参数校验异常:%s");

    //商品模块  5002xx

    //订单模块 5003XX

    //秒杀模块 5004XX
    public static CodeMsg MIAOSHA_OVER = new CodeMsg(500500, "商品已经秒杀结束");
    public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");




    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
