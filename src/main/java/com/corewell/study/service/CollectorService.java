package com.corewell.study.service;

import com.corewell.study.domain.Collector;
import com.corewell.study.domain.request.CollectorReq;
import com.corewell.study.domain.result.ResultMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/02/16:06
 * @Description:
 */
@Mapper
public interface CollectorService {
    /**
     * 查询采集器
     *
     * @param collectorReq
     * @return
     */
    ResultMsg findCollector(CollectorReq collectorReq);

    /**
     * 新增采集器
     *
     * @param collector
     * @return
     */
    ResultMsg insertCollector(Collector collector);

    /**
     * 修改采集器
     *
     * @param collector
     * @return
     */
    ResultMsg updateCollector(Collector collector);

    /**
     * 删除采集器
     *
     * @param id
     * @return
     */
    ResultMsg updateCollectorStatus(@Param("id") Long id);


}
