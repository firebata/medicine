package com.cnfwsy.interfaces.model.ent.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.mapper.ent.EntJobCominfoMapper;
import com.cnfwsy.interfaces.model.ent.IEntJobCominfoSrv;
import com.cnfwsy.interfaces.model.ent.helper.EntJobHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-09-12.
 */
@Service("entJobCominfoSrvImpl")
public class EntJobCominfoSrvImpl extends CommonSrvImpl<EntJobinfo> implements IEntJobCominfoSrv, InitializingBean {
    /**
     * 职位和公司关联查询
     */
    @Resource(name = "entJobCominfoMapper")
    private EntJobCominfoMapper entJobCominfoMapper;

    @Override
    public List<EntJobinfo> queryHotJobs(EntJobinfo entJobinfo) {
        List<EntJobinfo> jobinfos = entJobCominfoMapper.queryHotJobs(entJobinfo);
        EntJobHelper.SINGLETONE.encodeJobAnCompanyId(jobinfos);
        return jobinfos;
    }

    @Override
    public List<EntJobinfo> queryLatestJobs(EntJobinfo entJobinfo) {
        List<EntJobinfo> jobinfos = entJobCominfoMapper.queryLatestJobs(entJobinfo);
        EntJobHelper.SINGLETONE.encodeJobAnCompanyId(jobinfos);
        return jobinfos;
    }


    @Override
    public List<String> queryJobsIdsByDate(String now) {
        return entJobCominfoMapper.queryJobsIdsByDate(now);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        commonMapper = entJobCominfoMapper;
    }

    @Override
    public List<EntJobinfo> searchInfos(BaseForm info) {
        List<EntJobinfo> jobinfos = super.searchInfos(info);
        EntJobHelper.SINGLETONE.encodeJobAnCompanyId(jobinfos);
        return jobinfos;
    }

}
