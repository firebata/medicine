package com.cnfwsy.interfaces.model.ent.helper;

import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntCompany;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;

import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-08-23.
 */
public enum EntJobHelper {
    SINGLETONE;

    /**
     * 加密工作id和公司id
     *
     * @param jobinfos
     */
    public void encodeJobAnCompanyId(List<EntJobinfo> jobinfos) {
        if (null != jobinfos && jobinfos.size() > 0) {
            for (EntJobinfo jobinfo : jobinfos) {
                String jobId = jobinfo.getJobId().toString();
                jobId = Base64Utils.encode(jobId);
                String companyId = jobinfo.getCompanyId().toString();
                companyId = Base64Utils.encode(companyId);
                jobinfo.setJobId(jobId);
                jobinfo.setCompanyId(companyId);

                EntCompany company = jobinfo.getEntCompany();
                if (null != company) {
//                    String companyId = company.getCompanyId();
//                    companyId = Base64Utils.encode(companyId);
                    company.setCompanyId(companyId);
                }

            }
        }
    }
}
