package com.cnfwsy.core.model.init.helper;

import com.cnfwsy.core.api.SpringContextHolder;
import com.cnfwsy.core.bean.DictionaryVo;
import com.cnfwsy.core.cache.DictionaryInfoCachedMap;
import com.cnfwsy.core.model.init.IDictionarySrv;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/1.
 */
public enum DictionaryHelper {
    /**
     * 单例
     */
    SINGLETONE;


    public void initDictionary() {
        IDictionarySrv service = SpringContextHolder.getBean("dictionarySrv");
        List<DictionaryVo> dictionaries = service.queryAllDictionaries();
        initDictionaryMap(dictionaries);
    }


    public void initDictionaryMap(List<DictionaryVo> dictionaries) {
        for (int index = 0; index < dictionaries.size(); index++) {
            DictionaryVo dictionary = dictionaries.get(index);
            DictionaryInfoCachedMap.SINGLETONE.initDictionaryMap(dictionary);
        }

    }


}
