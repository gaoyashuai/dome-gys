package com.dome.controller;


import com.dome.monitor.TestEvent;
import com.dome.param.Result;
import com.dome.service.ITUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author gaoyashuai
 * @since 2020-06-18
 */
@Slf4j
@RestController
@RequestMapping("/gys/parent")
public class TUserController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/testListerner")
    public Result getListerner(String param){
        log.info("测试调用监听");
        TestEvent testEvent = new TestEvent(this,param);
        applicationEventPublisher.publishEvent(testEvent);
        System.out.println("监听结束");
        return new Result();
    }

    @Autowired
    private ITUserService userService;

    public Result getList (){
        List<String> userIdList = userService.getList();

        Result result = new Result();
        return result;
    }

}

