package com.dome.monitor.listerner;

import com.alibaba.fastjson.JSON;
import com.dome.domain.TUser;
import com.dome.monitor.TestEvent;
import com.dome.service.ITUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * CLASSNAME TestListerner
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/22 14:52
 * @Version 1.0
 */
@Slf4j
@Component
public class TestListerner implements ApplicationListener<TestEvent> {

    @Autowired
    private ITUserService itUserService;

    //监听器
    @Async(value = "taskExecutor")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onApplicationEvent(TestEvent testEvent) {

        TUser tUser = new TUser();
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        tUser.setUserId(uuidStr);
        tUser.setCreator(testEvent.getTestParam());
        itUserService.save(tUser);
        log.info("监听到的参数是：[{}]", JSON.toJSONString(testEvent));

        int i = 1/0;
    }

}
