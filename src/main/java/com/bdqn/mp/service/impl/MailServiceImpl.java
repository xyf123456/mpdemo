package com.bdqn.mp.service.impl;

import com.bdqn.mp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * ClassName: MailServiceImpl
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/24 22:33
 */
@Service
@ConfigurationProperties(prefix = "spring.mail")
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Value("${username}")
    private String sender;

    @Override
    public void sendActivationMail(String mailTo, String activationCode) {
        SimpleMailMessage activationMailMessage = new SimpleMailMessage();
        activationMailMessage.setFrom(sender);
        activationMailMessage.setTo(mailTo);
        activationMailMessage.setText("注册邮箱：" + mailTo + "  激活码：" + activationCode);
        mailSender.send(activationMailMessage);
    }
}
