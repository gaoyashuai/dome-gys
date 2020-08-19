package com.dome.param;

import com.dome.domain.TUser;
import lombok.Data;

import java.util.List;

/**
 * CLASSNAME ParentParam
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/21 21:44
 * @Version 1.0
 */
@Data
public class ParentParam {
    private String param01;
    private List<TUser> users;
}
