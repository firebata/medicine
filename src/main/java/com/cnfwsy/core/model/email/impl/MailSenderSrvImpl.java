package com.cnfwsy.core.model.email.impl;

import com.cnfwsy.core.model.email.IMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * 说明:
 * Created by zhangjh on 2016-08-09.
 */
@Service("mailSenderSrv")
public class MailSenderSrvImpl implements IMailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromAddress);
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(msgBody);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(toAddress);
        helper.setFrom(fromAddress);
        helper.setText(htmlBody, true);
        helper.setSubject(subject);

        mailSender.send(message);
    }

    @Override
    public void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody, String filePath) throws MessagingException, FileNotFoundException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(toAddress);
        helper.setFrom(fromAddress);
        helper.setText(htmlBody, true);
        helper.setSubject(subject);
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("找不到附件：" + filePath);
        }
        helper.addAttachment(file.getName(), file);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody, String filePath, String fileName) throws MessagingException, FileNotFoundException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(toAddress);
        helper.setFrom(fromAddress);
        helper.setText(htmlBody, true);
        helper.setSubject(subject);
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("找不到附件：" + filePath);
        }
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }
}
