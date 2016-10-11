package com.cnfwsy.interfaces.model.ent;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.ent.EntCompany;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-20 15:21:09
 */
public interface IEntCompanySrv extends ICommonSrv<EntCompany> {
    /**
     * 是否是hr本人
     */
    void isHrSelf(String companyId);

    void isHrSelf();

    boolean isComInfoCompleted();

    void toAuth(EntCompany entCompany);
}