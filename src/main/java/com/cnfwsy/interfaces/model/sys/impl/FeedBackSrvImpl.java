package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.utils.UuidGeneratorUtils;
import com.cnfwsy.interfaces.bean.sys.FeedBackVo;
import com.cnfwsy.interfaces.mapper.sys.FeedBackMapper;
import com.cnfwsy.interfaces.model.sys.IFeedBackSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 说明:
 * Created by zhangjh on 2016-07-22.
 */
@Service("feedBackSrvImpl")
public class FeedBackSrvImpl extends CommonSrvImpl<FeedBackVo> implements IFeedBackSrv, InitializingBean {

    @Resource(name = "feedBackMapper")
    private FeedBackMapper feedBackMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        commonMapper = feedBackMapper;
    }

    @Override
    public void add(FeedBackVo t) {
        String feedId = UuidGeneratorUtils.getRandomUUID();
        t.setFeedId(feedId);
        commonMapper.add(t);
    }

}
