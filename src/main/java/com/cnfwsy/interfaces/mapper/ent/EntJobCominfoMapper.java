package com.cnfwsy.interfaces.mapper.ent;

import com.cnfwsy.core.mapper.CommonMapper;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-07-31.
 */
@Repository("entJobCominfoMapper")
public interface EntJobCominfoMapper extends CommonMapper<EntJobinfo> {


    List<EntJobinfo> queryHotJobs(EntJobinfo entJobinfo);

    List<EntJobinfo> queryLatestJobs(EntJobinfo entJobinfo);

    List<String> queryJobsIdsByDate(@Param(value = "publishDate") String publishDate);
}
