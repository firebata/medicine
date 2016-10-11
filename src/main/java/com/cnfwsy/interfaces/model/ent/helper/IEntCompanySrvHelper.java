package com.cnfwsy.interfaces.model.ent.helper;

import com.cnfwsy.interfaces.bean.ent.EntCompany;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明:
 * Created by zhangjh on 2016-08-08.
 */
public enum IEntCompanySrvHelper {
    SINGLETONE;

    /**
     * 公司信息是否完善
     *
     * @param entCompany
     * @return
     */
    public boolean isComInfoCompleted(EntCompany entCompany) {
        boolean result = false;
        if (null != entCompany) {
            String name = entCompany.getCompanyName();
            String type = entCompany.getCompanyTypeId();
            String size = entCompany.getCompanySizeId();
            String industry = entCompany.getIndustryId();
            String province = entCompany.getProvinceId();
            String city = entCompany.getCityId();
            String summary = entCompany.getSummary();

            if ((StringUtils.isNotBlank(name) && !name.equals("-1"))) {
                if (StringUtils.isNotBlank(type) && !type.equals("-1")) {
                    if (StringUtils.isNotBlank(size) && !size.equals("-1")) {
                        if (StringUtils.isNotBlank(industry) && !industry.equals("-1")) {
                            if (StringUtils.isNotBlank(province) && !province.equals("-1")) {
                                if (StringUtils.isNotBlank(city) && !city.equals("-1")) {
                                    if (StringUtils.isNotBlank(summary) && !summary.equals("-1")) {
                                        result = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
