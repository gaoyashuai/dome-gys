package com.dome.config.exception;

import lombok.Data;

/**
 * 全局异常类
 */
@Data
public class GlobalException extends RuntimeException{
    private CodeMsg codeMsg;
    private String msg;
    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.toString());
        this.codeMsg=codeMsg;
    }

    public GlobalException(CodeMsg codeMsg,String message){
        super(codeMsg.toString());
        this.msg = message;
        this.codeMsg=codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}