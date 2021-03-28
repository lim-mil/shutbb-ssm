package com.limyel.shutbb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailUtil {
    private SimpleMailMessage mailMessage;
    private JavaMailSenderImpl javaMailSender;
    private String host;

    @Autowired
    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    @Autowired
    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        javaMailSender.setJavaMailProperties(properties);
    }

    public void sendEmail(String addressTo, String code) {
        StringBuffer text = new StringBuffer("这是一封激活邮件,激活请点击以下链接 ");
        text.append(host);
        text.append("/email/active/");
        text.append(code);
        SimpleMailMessage message = new SimpleMailMessage(mailMessage);
        message.setTo(addressTo);
        message.setText(text.toString());
        javaMailSender.send(message);
    }
}
