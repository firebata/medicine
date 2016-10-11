package com.cnfwsy.core.model.init;

import com.cnfwsy.core.bean.DictionaryVo;

import java.util.List;

/**
 * Created by zhangjh on 2015/6/1.
 */
public interface IDictionarySrv {
    public List<DictionaryVo> queryAllDictionaries();
}
