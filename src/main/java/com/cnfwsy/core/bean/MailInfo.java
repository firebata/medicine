package com.cnfwsy.core.bean;

import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-08-09.
 */
public class MailInfo {

    private String fromAddress;
    private String[] toEmails;

    private String subject;
    private Map data;          //邮件数据
    private String template;    //邮件模板

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String[] getToEmails() {
        return toEmails;
    }

    public void setToEmails(String[] toEmails) {
        this.toEmails = toEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
