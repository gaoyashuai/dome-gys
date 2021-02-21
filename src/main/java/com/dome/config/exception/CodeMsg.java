package com.dome.config.exception;

public class CodeMsg {

    private String code;
    private String msg;

    //通用异常
    public static CodeMsg SUCCESS = new CodeMsg("0", "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg("500100", "服务端异常");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg("40000", "数据异常");
    //注意  %s ，格式化字符串
    public static CodeMsg SERVER_BIND_ERROR = new CodeMsg("500101", "服务端绑定异常:%s");


    private CodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return 异常CodeMsg 对象生成方法
     */

    public CodeMsg fillArgs(Object... args) {
        String code = this.code;
        String message = String.format(msg, args);
        return new CodeMsg(code, message);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}