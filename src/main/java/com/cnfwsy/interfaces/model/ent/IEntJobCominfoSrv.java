package com.cnfwsy.interfaces.model.ent;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;

import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-09-12.
 */
public interface IEntJobCominfoSrv extends ICommonSrv<EntJobinfo> {


    List<EntJobinfo> queryHotJobs(EntJobinfo entJobinfo);

    List<EntJobinfo> queryLatestJobs(EntJobinfo entJobinfo);

    List<String> queryJobsIdsByDate(String now);
}
