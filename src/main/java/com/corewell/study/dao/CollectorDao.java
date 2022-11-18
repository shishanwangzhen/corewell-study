package com.corewell.study.dao;

import com.corewell.study.domain.Collector;
import com.corewell.study.domain.request.CollectorReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface CollectorDao {
    /**
     * 查询采集器
     *
     * @param CollectorReq
     * @return
     */
    List<Collector> findCollector(CollectorReq CollectorReq);

    /**
     * 新增采集器
     *
     * @param Collector
     * @return
     */
    int insertCollector(Collector Collector);

    /**
     * 修改采集器
     *
     * @param Collector
     * @return
     */
    int updateCollector(Collector Collector);

    /**
     * 删除采集器
     *
     * @param id
     * @return
     */
    int updateCollectorStatus(@Param("id") Long id);


}
