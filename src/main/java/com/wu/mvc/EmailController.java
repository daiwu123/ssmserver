package com.wu.mvc;

import com.wu.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Controller
public class EmailController {

    @Autowired
    private EmailUtil emailUtil;
    @ResponseBody
    @RequestMapping("/send")
    public String sendMail(){
        String filePath = "D:/测试附件.xlsx";
        try {
            emailUtil.sendEmail(filePath,"测试附件.xlsx");
        } catch (MessagingException | GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
