package com.dome.domain;

import lombok.Data;

import java.util.List;

/**
 * CLASSNAME Test
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/8/7 16:45
 * @Version 1.0
 */
@Data
public class Test {
    private String name;
    private List<Book> list;
}
