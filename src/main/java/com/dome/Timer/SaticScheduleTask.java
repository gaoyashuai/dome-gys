package com.dome.Timer;

import com.dome.utils.ActsocialMailSender;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

/**
 * CLASSNAME SaticScheduleTask
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/29 10:37
 * @Version 1.0
 */
@Configuration
@EnableScheduling
public class SaticScheduleTask {

    @Scheduled(cron = "50 42 15 * * ?")
    public void sendMail(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        Map<String,Object> model = new HashMap<String,Object>();
        model.put("userName","yashuai.gao");
        model.put("emailAddress", "***@163.com");
        ActsocialMailSender.sendEmail(model,"欢迎加入", "welcome.vm",new String[]{"***@163.com"},new String[]{});


    }
}
