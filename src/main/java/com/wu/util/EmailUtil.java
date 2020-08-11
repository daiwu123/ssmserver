package com.wu.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Component
public class EmailUtil {

    public void sendEmail(String filePath,String fileName) throws MessagingException, GeneralSecurityException, UnsupportedEncodingException {
        Properties properties = new Properties();
        //设置ssl加密邮件发送
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        //启动ssl，但是会有问题，ssl是需要按照https协议来的，但是我们这里是http，所有会有问题
        //  properties.put("mail.smtp.ssl.enable", "true");
        //properties.put("mail.smtp.ssl.socketFactory", sf);
        //properties.put("mail.smtp.socketFactory.port", "465");//设置ssl端口
        //properties.put("mail.smtp.socketFactory.fallback", "false");
        //properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //配置host
        properties.put("mail.smtp.host","smtp.qq.com");
        //配置port
        properties.put("mail.smtp.port","587");
        /*properties.put("mail.smtp.ssl.enable",true);*/
        //配置是否需要验证
        properties.put("mail.smtp.auth","true");
        //properties.put("");
        //验证
        Authenticator authenticator = new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("894715706@qq.com","geydpmnqrnprbdhj");
            }
        };
        Session mailSession = Session.getInstance(properties,authenticator);
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        //邮件主题
        mimeMessage.setSubject("附件Test邮件sadada");
        //发送者
        mimeMessage.setFrom(new InternetAddress("894715706@qq.com"));
       // InternetAddress []toAddress =  {new InternetAddress("daiwu@newfis.com")};
        //回复哪些人
       // mimeMessage.setReplyTo(toAddress);
        //设置接收者
        mimeMessage.setRecipients(Message.RecipientType.TO,"1341873170@qq.com");
        //设置抄送给哪些人
        mimeMessage.setRecipients(Message.RecipientType.CC,"daiwu@newfis.com");
        mimeMessage.setDescription("此邮件紧紧用于测试","utf-8");
        Multipart multipart  = new MimeMultipart();
        //邮件内容
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setContent("<a href=\"www.baidu.com\">测试邮件内容....</a>","text/html;charset=utf-8");
       // contentPart.setText("<a href='www.baidu.com'>测试邮件内容....</a>","text/html;charset=utf-8");
        multipart.addBodyPart(contentPart);
        //附件
        BodyPart attaPart = new MimeBodyPart();
        // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
        //BASE64Encoder enc = new BASE64Encoder();
        //attaPart.setFileName("=?GBK?B?" + enc.encode(fileName.getBytes()) + "?=");
        //转码,不然文件会乱码
        attaPart.setFileName(MimeUtility.encodeText(fileName));
        //文件的地址
        DataSource dataSource = new FileDataSource(filePath);
        DataHandler attaData = new DataHandler(dataSource);
        attaPart.setDataHandler(attaData);
        multipart.addBodyPart(attaPart);
        mimeMessage.setContent(multipart);
        //保存邮件
        mimeMessage.saveChanges();
        //发送邮件 ， 通过smtp发送协议发送
       // Transport smtpTransfer = mailSession.getTransport("smtp");
        //smtpTransfer.connect("smtp.qq.com","894715706@qq.com","geydpmnqrnprbdhj");
        Transport.send(mimeMessage);

    }

}
