package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.utils.UuidGeneratorUtils;
import com.cnfwsy.interfaces.bean.sys.SysSms;
import com.cnfwsy.interfaces.constant.BusinessConstant;
import com.cnfwsy.interfaces.model.sys.IVerifyCode;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-08-08.
 */
@Service("_webchinese")
public class WebchineseVerifyCode implements IVerifyCode {

    static Logger logger = LoggerFactory.getLogger(WebchineseVerifyCode.class);

    @Autowired
    private INoGenerator verificationCodeGenerator;

    /**
     * @param info
     * @param smc_verification
     * @return
     * @throws IOException
     */
    @Override
    public SysSms sendSms(SysSms info, Map<String, String> smc_verification) throws IOException {
        String mobile = info.getMobile();
        String platform = BusinessConstant.CURRENT_PLATFORM;
        String vcode = verificationCodeGenerator.offer().toString();
        int effective_time = Integer.parseInt(smc_verification.get(BusinessConstant.EFFECTIVE_TIME));
        String template = smc_verification.get(BusinessConstant.TEMPLATE);
        String content = MessageFormat.format(template, vcode, effective_time);
        String currentPlatform = smc_verification.get(platform);
        String api = smc_verification.get(currentPlatform);
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(api);
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
        NameValuePair[] data = {new NameValuePair("Uid", "firebata"), new NameValuePair("Key", "d77bf599894c77e1ec8c"), new NameValuePair("smsMob", mobile), new NameValuePair("smsText", content)};
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
//        logger.info("statusCode:" + statusCode);
//        for (Header h : headers) {
//            logger.info(h.toString());
//        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
//        logger.info(result); //打印返回消息状态

        String smsId = UuidGeneratorUtils.getRandomUUID();

        post.releaseConnection();
        info.setSmsId(smsId);
        info.setSmsName(content);
        info.setMobile(mobile);
        info.setPlatformKind(currentPlatform);
        info.setVcode(vcode);
        info.setStatus(BusinessConstant.SMC_DOWN);
        return info;
    }
}
