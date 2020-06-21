package com.dome.Enum;

import lombok.Data;

/**
 * CLASSNAME ParentEnum
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/21 21:47
 * @Version 1.0
 */
public enum ParentEnum {

    MEN("men","男"),
    WOMEN("women","女");

    private String code;
    private String message;

    ParentEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

}
