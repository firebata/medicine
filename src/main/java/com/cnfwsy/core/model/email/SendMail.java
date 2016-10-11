package com.cnfwsy.core.model.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * 说明:
 * Created by zhangjh on 2016-08-09.
 */
public class SendMail {

    public static void main(String[] args) throws AddressException {
//        boolean isSSL = true;
        String host = "smtp.ym.163.com";
        int port = 25;
        String from = "info@zzlinks.cn";
        String to = "565068729@qq.com";
        boolean isAuth = true;
        final String username = "info@zzlinks.cn";
        final String password = "WSX123,.plm";

        Properties props = new Properties();
//        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("［邀请函］国内知名医学生物人才平台招徕网正在邀请您注册！截止10月30日前注册的企业用户将免费获得半年使用权限！");


            String contet = "<html>\n" +
                    "<body>\n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; \">\n" +
                    "    <tbody>\n" +
                    "    <tr>\n" +
                    "        <td width=\"100%\" bgcolor=\"#EDEDEE\" align=\"center\" style=\"padding-right:10px; padding-left:10px; \">\n" +
                    "            <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"full-block\"\n" +
                    "                   style=\"border-collapse:collapse; background:white;\">\n" +
                    "                <tbody>\n" +
                    "                <tr>\n" +
                    "                    <td width=\"35\"></td>\n" +
                    "                    <td>\n" +
                    "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "                            <tbody>\n" +
                    "                            <tr>\n" +
                    "                                <td colspan=\"3\"\n" +
                    "                                    style=\"padding-top:29px;color: #595757; font-size: 13px;text-align:left;font-family: '宋体'; line-height:23px;\">\n" +
                    "                                    由<span style=\"font-family: Arial;\">广州普壳软件</span>为您打造的“医学生物人才库”企业注册如火如荼的进行中，我们诚邀注册。\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td colspan=\"3\"\n" +
                    "                                    style=\"padding-top:22px;padding-bottom:23px;color: #01ad9d; font-size: 17px; font-weight:bold;text-align:center;font-family: '宋体';\">\n" +
                    "                                    招徕网 | 国内知名医学生物人才平台\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td style=\"text-align: center;padding-bottom:26px\">\n" +
                    "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "                                        <tbody>\n" +
                    "                                        <tr>\n" +
                    "                                            <td style=\"font-family:'微软雅黑'; font-size:13px;color:#01ad9d;line-height:24px;\"\n" +
                    "                                                width=\"10\"\n" +
                    "                                                valign=\"top\">●\n" +
                    "                                            </td>\n" +
                    "                                            <td style=\"color: #595757; font-size: 13px; line-height:23px; font-family: '宋体'; text-align: left;padding-left:5px;padding-bottom:10px\">\n" +
                    "                                                <span style=\"font-weight:bold;\">人才库</span>：平台目前拥有 <span\n" +
                    "                                                    style=\"font-family: Arial;\">50</span>\n" +
                    "                                                万已注册的医学、生物人才，从护士到院长，从基层岗位到合伙人，从国内学历到海归博士，从应届毕业生到学科带头人。\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        <tr>\n" +
                    "                                            <td style=\"font-family:'微软雅黑'; font-size:13px;color:#01ad9d;line-height:24px;\"\n" +
                    "                                                width=\"15\"\n" +
                    "                                                valign=\"top\">●\n" +
                    "                                            </td>\n" +
                    "                                            <td style=\"color: #595757; font-size: 13px; line-height:23px; font-family: '宋体'; text-align: left;padding-left:5px;\">\n" +
                    "                                                <span style=\"font-weight:bold;\">专业性</span>：平台汇聚了医院、医学类大学、科研单位、制药企业、生物企业、医疗器械、美容、检测机构、防御中心、课题组等机构。\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        <tr>\n" +
                    "                                            <td style=\"font-family:'微软雅黑'; font-size:13px;color:#01ad9d;line-height:24px;\"\n" +
                    "                                                width=\"15\"\n" +
                    "                                                valign=\"top\">●\n" +
                    "                                            </td>\n" +
                    "                                            <td style=\"color: #595757; font-size: 13px; line-height:23px; font-family: '宋体'; text-align: left;padding-left:5px;padding-bottom:10px\">\n" +
                    "                                                <span style=\"font-weight:bold;\">精准性</span>：人工智能、大数据云计算、智能筛选、人员测评。每天节省HR90%看简历的时间，智能匹配筛选简历\n" +
                    "                                                基于10年招聘经理甄选简历经验研发\n" +
                    "                                                同时管理多个招聘渠道。\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "                                        <tr>\n" +
                    "                                            <td style=\"font-family:'微软雅黑'; font-size:13px;color:#01ad9d;line-height:24px;\"\n" +
                    "                                                width=\"15\"\n" +
                    "                                                valign=\"top\">●\n" +
                    "                                            </td>\n" +
                    "                                            <td style=\"color: #595757; font-size: 13px; line-height:23px; font-family: '宋体'; text-align: left;padding-left:5px;\">\n" +
                    "                                                <span style=\"font-weight:bold;\">猎 头</span>：提供招聘全流程人才跟踪保入职服务，资深猎头顾问服务团队，均5年以上猎头经验，解决当下众多快速发展企业/机构面临人才精细化战略的刚性需求。\n" +
                    "                                            </td>\n" +
                    "                                        </tr>\n" +
                    "\n" +
                    "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "                                </td>\n" +
                    "                            </tr>\n" +
                    "                            </tbody>\n" +
                    "                        </table>\n" +
                    "                    </td>\n" +
                    "                    <td width=\"35\"></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td colspan=\"3\" height=\"15\" bgcolor=\"#EDEDEE\"></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td width=\"35\"></td>\n" +
                    "                    <td>\n" +
                    "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "                            <tbody>\n" +
                    "                            <tr>\n" +
                    "                                <td></td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td width=\"225\"></td>\n" +
                    "                                <td width=\"150\" height=\"33\" align=\"center\" valign=\"middle\" bgcolor=\"#00AE9E\">\n" +
                    "                                    <a style=\"font-family: '宋体';font-size: 13px;color: white; text-decoration: none;\"\n" +
                    "                                       href=\"http://www.zzlinks.cn/index.html\" target=\"_blank\">立即注册加入</a>\n" +
                    "                                </td>\n" +
                    "                                <td width=\"225\"></td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td colspan=\"3\" height=\"32\"></td>\n" +
                    "                            </tr>\n" +
                    "                            </tbody>\n" +
                    "                        </table>\n" +
                    "                    </td>\n" +
                    "                    <td width=\"35\"></td>\n" +
                    "                </tr>\n" +
                    "                </tbody>\n" +
                    "            </table>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "</html>\n";
            Multipart mainPart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(contet, "text/html; charset=utf-8");
            mainPart.addBodyPart(messageBodyPart);
            message.setContent(mainPart);

//            message.setText(contet);

            Transport.send(message);

            System.out.println("发送完毕！");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
