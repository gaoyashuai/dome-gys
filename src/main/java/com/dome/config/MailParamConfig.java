package com.dome.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * CLASSNAME MailParamConfig
 *
 * @author gaoyashuai
 * @description:
 * @date 2020/6/8 13:41
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailParamConfig {

    /**
     * 邮箱账号
     */
    public String account;

    /**
     * 密码
     */
    public String pwd;

    /**
     * 邮件服务器
     */
    public String host;

    /**
     * debug模式
     */
    public boolean debug;

    public String port;

}
