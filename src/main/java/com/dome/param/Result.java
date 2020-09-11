package com.dome.param;

import com.dome.config.exception.CodeMsg;
import lombok.Data;

/**
 * CLASSNAME Result
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/22 14:55
 * @Version 1.0
 */
@Data
public class Result {
    private String code = "200";
    private String message = "调用成功";
    private Object data;

    public Result(String code, String msg) {
        this.code=code;
        this.message = msg;
    }

    public static Result error(CodeMsg fillArgs) {
        Result result = new Result();
        result.setCode(fillArgs.getCode());
        result.setMessage(fillArgs.getMsg());
        return result;
    }

    public Result() {
    }
}
