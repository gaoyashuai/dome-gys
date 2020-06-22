package com.dome.param;

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
}
