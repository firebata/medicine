package com.cnfwsy.core.model.email;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.io.FileNotFoundException;

/**
 * 说明:
 * Created by zhangjh on 2016-08-09.
 */
public interface IMailSender {
    /**
     * 功能: 发普通邮件，msgBody是普通的文本
     *
     * @param toAddress
     * @param fromAddress
     * @param subject
     * @param msgBody
     */
    void sendEmail(String toAddress, String fromAddress, String subject, String msgBody);

    /**
     * 功能: 发html邮件或者普通邮件，msgBody是html文本或者普通文本.<br/>
     * MimeMessage 消息发送.<br/>
     *
     * @param toAddress
     * @param fromAddress
     * @param subject
     * @param htmlBody
     * @throws MessagingException
     */
    void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody) throws MessagingException, javax.mail.MessagingException;

    /**
     * 功能: 发html邮件或者普通邮件，msgBody是html文本或者普通文本，带附件.<br/>
     * MimeMessage 消息发送.<br/>
     *
     * @param toAddress
     * @param fromAddress
     * @param subject
     * @param htmlBody
     * @param filePath
     * @throws MessagingException
     * @throws FileNotFoundException
     */
    void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody, String filePath)
            throws MessagingException, FileNotFoundException, javax.mail.MessagingException;

    /**
     * 功能: 发html邮件或者普通邮件，msgBody是html文本或者普通文本，带附件.<br/>
     * MimeMessage 消息发送.<br/>
     *
     * @param toAddress
     * @param fromAddress
     * @param subject
     * @param htmlBody
     * @param filePath
     * @param fileName
     * @throws MessagingException
     * @throws FileNotFoundException
     */
    void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody, String filePath,
                       String fileName) throws MessagingException, FileNotFoundException, javax.mail.MessagingException;
}
