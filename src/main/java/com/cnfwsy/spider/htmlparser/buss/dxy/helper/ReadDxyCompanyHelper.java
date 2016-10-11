package com.cnfwsy.spider.htmlparser.buss.dxy.helper;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 说明:
 * Created by zhangjh on 2016-07-26.
 */
public enum ReadDxyCompanyHelper {
    SINGLETONE;
    Logger logger = Logger.getLogger(ReadDxyCompanyHelper.class.getName());

    /**
     * @param cominfo
     */
    public void readComUrl(Ent_company cominfo) {

        int step = cominfo.getStep();
        String url = cominfo.getCom_url();
        logger.info("公司url:" + url);
        if (step == AppConstant.step_1) {
            cominfo.setThird_kind(AppConstant.dxy);
            cominfo.setStep(AppConstant.step_2);
            try {

                Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2729.4 Safari/537.36").get();
                //职位要求
                Elements ps = doc.select("div .header_ehp .hd .fl  p");
                if (null != ps && ps.size() > 0) {
                    String p = ps.text();
                    String[] infoArr = p.split("-");
                    for (int idx = 0, len = infoArr.length; idx < len; idx++) {
                        String val = infoArr[idx].trim();
                        if (idx == 0) {//省份
                            cominfo.setProvince_name(val);
                        } else if (idx == 1) {
                            cominfo.setCompany_type_name(val);
                        } else if (idx == 2) {//二甲 ：1000~9999人 或者  ：1000~9999人
                            String[] infoArrSub = val.split("：");
                            for (int idx2 = 0, len2 = infoArrSub.length; idx2 < len2; idx2++) {
                                String val2 = infoArrSub[idx2].trim();
                                if (idx2 == 0) {//医院等级
                                    cominfo.setHosp_level_name(val2);
                                } else if (idx2 == 1) {//医院人数
                                    cominfo.setCompany_size_name(val2);
                                    cominfo.setScale_name(val2);
                                }
                            }
                        }
                    }

                }

//                DxyComUpdateQueue.put(cominfo);
                DbUtils.updateComDxy1(cominfo);
            } catch (Exception e) {
                logger.error("解析公司信息报错,公司url:" + url, e);
            }


        }


    }
}
