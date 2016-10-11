package com.cnfwsy.core.model.common;

import com.cnfwsy.core.bean.BaseForm;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangjh on 2016/6/8.
 */
public interface ICommonSrv<T> {

    Map<String, String> options(String keyName, String valueName);

    /**
     * @return
     */
    int listInfosCounts();


    /**
     * 过滤条件的记录数
     *
     * @param baseForm BaseForm
     * @return
     */
    int listFilteredInfosCounts(BaseForm baseForm);


    /**
     * 结果集合
     *
     * @param baseForm
     * @return
     */
    List<T> searchInfos(BaseForm baseForm);

    /**
     * @param t
     */
    void edit(T t);

    /**
     * @param natrualkey
     * @return 根据natrualkey找出供应商信息
     */
    <T> T queryInfoByNatrualKey(String natrualkey);

    void add(T t);

    void del(String natrualkey);


    void addBatch(List<T> infos);

    void updateBatch(List<T> infos);


    void delByParentId(String parentId);
}
