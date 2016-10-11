package com.cnfwsy.core.model.init.impl;

import com.cnfwsy.core.bean.DictionaryVo;
import com.cnfwsy.core.mapper.DictionaryMapper;
import com.cnfwsy.core.model.init.IDictionarySrv;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangjh on 2015/6/1.
 */
@Service("dictionarySrv")
public class DictionarySrvImpl implements IDictionarySrv {
    @Resource(name = "dictionaryMapper")
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<DictionaryVo> queryAllDictionaries() {
        return dictionaryMapper.searchDictionary();
    }
}
