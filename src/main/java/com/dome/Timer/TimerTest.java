package com.dome.Timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * CLASSNAME TimerTest
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/23 12:50
 * @Version 1.0
 */
public class TimerTest {
    public static void main(String[] args){
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2020);//控制年
        calendar.set(Calendar.MINUTE,5);//控制月份
        calendar.set(Calendar.DAY_OF_MONTH,23);//控制日期
        calendar.set(Calendar.HOUR_OF_DAY, 12);//控制小时
        calendar.set(Calendar.MINUTE, 49);//控制分钟
        calendar.set(Calendar.SECOND, 0);//控制秒
        Date time = calendar.getTime();//执行任务时间为12:00:00

        //每天定时12:00执行操作，延迟一天后再执行
        new Timer().schedule(new TimerTaskTest(), time ,1000 * 60 * 60 * 24);
    }
}
