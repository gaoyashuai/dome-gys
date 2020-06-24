package com.dome.strategy;

import com.dome.Timer.TimerTaskTest;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

@Data
@Component
public class StrategyFactory implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("进入run");
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2020);//控制年
        calendar.set(Calendar.MINUTE,5);//控制月份
        calendar.set(Calendar.DAY_OF_MONTH,24);//控制日期
        calendar.set(Calendar.HOUR_OF_DAY, 11);//控制小时
        calendar.set(Calendar.MINUTE, 30);//控制分钟
        calendar.set(Calendar.SECOND, 30);//控制秒
        Date time = calendar.getTime();//执行任务时间为12:00:00

        //每天定时12:00执行操作，延迟一天后再执行
        new Timer().schedule(new TimerTaskTest(), time);

    }
}