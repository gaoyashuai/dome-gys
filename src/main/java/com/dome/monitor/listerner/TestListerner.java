package com.dome.monitor.listerner;

import com.alibaba.fastjson.JSON;
import com.dome.monitor.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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

    //监听器
    @Async(value = "taskExecutor")
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("监听到的参数是：[{}]", JSON.toJSONString(testEvent));
    }

}
