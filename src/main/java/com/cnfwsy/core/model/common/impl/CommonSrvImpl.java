package com.cnfwsy.core.model.common.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.mapper.CommonMapper;
import com.cnfwsy.core.model.common.ICommonSrv;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T>
 */
public abstract class CommonSrvImpl<T> implements ICommonSrv<T> {

    protected CommonMapper<T> commonMapper;
    protected transient Log logger = LogFactory.getLog(getClass());

    @Override
    public int listInfosCounts() {
        return commonMapper.listInfosCounts();
    }

    public Map<String, String> options(String keyName, String valueName) {
        List<Map<String, String>> list = commonMapper.options();
        Map<String, String> map = new HashMap<String, String>();
        if (null != list && list.size() > 0) {
            for (Map<String, String> one : list) {
                String key = String.valueOf(one.get(keyName));
                String value = String.valueOf(one.get(valueName));
                map.put(key, value);
            }
        }
        return map;
    }

    /**
     * @param baseForm
     * @return
     */
    public int listFilteredInfosCounts(BaseForm baseForm) {
        return commonMapper.listFilteredInfosCounts(baseForm);
    }

    /**
     * @param baseForm
     * @return
     */
    @Override
    public List<T> searchInfos(BaseForm baseForm) {
        List<T> resut;
        resut = commonMapper.searchInfos(baseForm);
        return resut;
    }

    @Override
    public void add(T t) {
        commonMapper.add(t);
    }

    @Override
    public void edit(T t) {
        commonMapper.updateInfo(t);
    }

    @Override
    public T queryInfoByNatrualKey(String natrualKey) {
        return commonMapper.queryInfo(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        commonMapper.del(natrualKey);
    }


    @Override
    public void addBatch(List<T> infos) {
        commonMapper.addBatch(infos);
    }

    @Override
    public void updateBatch(List<T> infos) {
        commonMapper.updateBatch(infos);
    }

    @Override
    public void delByParentId(String parentId) {
        commonMapper.delByParentId(parentId);
    }


}
