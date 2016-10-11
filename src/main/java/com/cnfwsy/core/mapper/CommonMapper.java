package com.cnfwsy.core.mapper;

import com.cnfwsy.core.bean.BaseForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangjh on 2015/6/8.
 */
public interface CommonMapper<T> {

    int listInfosCounts();

    List<Map<String, String>> options();

    void updateInfo(T t);

    <T> T queryInfo(String natrualKey);

    void add(T t);

    void del(String natrualKey);

    String queryCurrentSeqNo();


    void addBatch(@Param(value = "list") List<T> list);

    void updateBatch(@Param(value = "list") List<T> infos);


    <T> List<T> searchInfos(BaseForm baseForm);

    int listFilteredInfosCounts(BaseForm baseForm);

    String queryBusinessName(@Param(value = "businessKey") String businessKey);

    void delByParentId(@Param(value = "parentId") String parentId);
}
