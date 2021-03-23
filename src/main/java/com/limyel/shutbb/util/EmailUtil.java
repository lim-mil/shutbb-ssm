package com.limyel.shutbb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private SimpleMailMessage mailMessage;
    private String host;

    @Autowired
    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    public void sendEmail(String addressTo, String code) {
        StringBuffer text = new StringBuffer("这是一封激活邮件,激活请点击以下链接 ");
        SimpleMailMessage message = new SimpleMailMessage(mailMessage);

    }
}
