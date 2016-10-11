package com.cnfwsy.spider.htmlparser.constant;

import java.math.BigInteger;
import java.util.regex.Pattern;

public interface AppConstant {
    BigInteger Addend = new BigInteger("6666");
    String _51job = "51job";
    String liepin = "liepin";
    String dxy = "dxy";
    String zhaopin = "zhaopin";
    String doctorjob = "doctorjob";
    String ecaihr = "ecaihr";

    int step_0 = 0;// 爬虫阶段:0,概要阶段(职位列表)；1，详细阶段
    int step_1 = 1;// 中间状态：查询队列中，还未解析
    int step_2 = 2;// 已解析
    int status_0 = 0;// 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）

    String provinces = "全国,北京,上海,天津,重庆,河北,山西,内蒙古,辽宁,吉林,黑龙江,江苏,浙江,安徽,福建,江西,山东,河南,湖北,湖南,广东,广西,海南,四川,贵州,云南,西藏,陕西,甘肃,新疆,青海,宁夏,香港,澳门,台湾";
    String EMAIL_REGEX = "[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
    String MOBILE_REGEX = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    String TEL_REGEX = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +
            "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
    Pattern EMAiL_PATTERN = Pattern.compile(EMAIL_REGEX);
    Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);
    Pattern TEL_PATTERN = Pattern.compile(TEL_REGEX);
    String yiyuan_industryid = "101";
    String yiyuan_industryname = "医疗/护理/卫生";
}
