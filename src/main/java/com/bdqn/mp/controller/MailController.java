package com.bdqn.mp.controller;

import com.bdqn.mp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: MailController
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/24 22:32
 */
@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    @ResponseBody
    public Object send(String mailTo, String activationCode) {
        try {
            mailService.sendActivationMail(mailTo, activationCode);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
