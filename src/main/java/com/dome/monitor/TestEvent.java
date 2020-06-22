package com.dome.monitor;

import org.springframework.context.ApplicationEvent;

/**
 * CLASSNAME TestEvent
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/22 14:50
 * @Version 1.0
 */
public class TestEvent extends ApplicationEvent {

    private String testParam;

    public TestEvent(Object source, String testParam) {
        super(source);
        this.testParam = testParam;
    }

    public String getTestParam() {
        return testParam;
    }

    public void setTestParam(String testParam) {
        this.testParam = testParam;
    }
}
