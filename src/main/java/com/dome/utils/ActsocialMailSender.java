package com.dome.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
import sun.rmi.runtime.Log;

/**
 * CLASSNAME ActsocialMailSender
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/29 14:15
 * @Version 1.0
 */
public class ActsocialMailSender {
    //从配置文件中读取相应的邮件配置属性
    private static final String emailHost = "smtp.163.com";
    private static final String userName = "***@163.com";
    private static final String password = "*****";
    private static final String mailAuth = "true";


    private static Map<String, Object> proMap = null;
    private static JavaMailSenderImpl instance = null;
    private static VelocityEngine velocityEngine = null;

    static {
        proMap = new HashMap<String, Object>();
        proMap.put("resource.loader", "class");
        proMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

    }

    public static JavaMailSender getInstance() {
        if (null == instance) {
            synchronized (JavaMailSenderImpl.class) {
                if (null == instance) {
                    instance = new JavaMailSenderImpl();
                    instance.setHost(emailHost);
                    instance.setUsername(userName);
                    instance.setPassword(password);
                    Properties properties = new Properties();
                    properties.setProperty("mail.smtp.auth", mailAuth);
                    //使用gmail发送邮件是必须设置如下参数的 主要是port不一样
                    if (emailHost.indexOf("smtp.gmail.com") >= 0) {
                        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
                        properties.setProperty("mail.smtp.port", "25");
                        properties.setProperty("mail.smtp.socketFactory.port", "25");
                    }
                    instance.setJavaMailProperties(properties);
                }
            }
        }

        return instance;
    }

    public static VelocityEngine getVelocityEngineInstance() {
        if (null == velocityEngine) {
            synchronized (VelocityEngine.class) {
                if (null == velocityEngine) {
                    velocityEngine = new VelocityEngine();
                    for (Map.Entry<String, Object> entry : proMap.entrySet()) {
                        velocityEngine.setProperty(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return velocityEngine;
    }

    public static void sendEmail(final Map<String, Object> model, final String subject, final String vmfile, final String[] mailTo, final String[] files) {
        System.out.println("发送邮件开始");

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            //注意MimeMessagePreparator接口只有这一个回调函数
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "GBK");
                //这是一个生成Mime邮件简单工具，如果不使用GBK这个，中文会出现乱码
                //如果您使用的都是英文，那么可以使用MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(mailTo);//设置接收方的email地址
                message.setSubject(subject);//设置邮件主题
                message.setFrom(userName);//设置发送方地址
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        ActsocialMailSender.getVelocityEngineInstance(), vmfile, "UTF-8", model);
                //从模板中加载要发送的内容，vmfile就是模板文件的名字
                //注意模板中有中文要加GBK，model中存放的是要替换模板中字段的值
                message.setText(text, true);
                //将发送的内容赋值给MimeMessageHelper,后面的true表示内容解析成html
                //如果您不想解析文本内容，可以使用false或者不添加这项
                FileSystemResource file;
                for (String s : files)//添加附件
                {
                    file = new FileSystemResource(new File(s));//读取附件
                    message.addAttachment(s, file);//向email中添加附件
                }
            }
        };
        ActsocialMailSender.getInstance().send(preparator);//发送邮件

        System.out.println("=== 发送结束");
    }

    public static void sendAlertEmail(final Map<String, Object> model, final String[] mailTo) {
        sendEmail(model, "", "", mailTo, new String[]{});
    }
}