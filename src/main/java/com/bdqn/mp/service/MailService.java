package com.bdqn.mp.service;

/**
 * ClassName: MailService
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/24 22:33
 */
public interface MailService {

    void sendActivationMail(String mailTo, String activationCode);
}
