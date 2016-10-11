package com.cnfwsy.interfaces.model.ent;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-20 15:21:09
 */
public interface IEntJobinfoSrv extends ICommonSrv<EntJobinfo> {


    EntJobinfo queryInfoById(String businessKey);


}