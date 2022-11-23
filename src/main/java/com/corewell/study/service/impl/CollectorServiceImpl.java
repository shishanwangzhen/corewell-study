package com.corewell.study.service.impl;

import com.corewell.study.dao.CollectorDao;
import com.corewell.study.domain.Collector;
import com.corewell.study.domain.request.CollectorReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/17/13:31
 * @Description:
 */
@Service("CollectorService")
public class CollectorServiceImpl implements CollectorService {

    @Autowired
    private CollectorDao CollectorDao;

    @Override
    public ResultMsg findCollector(CollectorReq collectorReq) {
        List<Collector> CollectorList = CollectorDao.findCollector(collectorReq);
        return ResultMsg.success(CollectorList);
    }

    @Override
    public ResultMsg insertCollector(Collector collector) {
        collector.setCreateTime(new Date());
        collector.setStatus("0");
        collector.setDeleteFlag("1");
        int result = CollectorDao.insertCollector(collector);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateCollector(Collector collector) {
        collector.setUpdateTime(new Date());
        int result = CollectorDao.updateCollector(collector);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    public ResultMsg updateCollectorStatus(Long id) {
        int result = CollectorDao.updateCollectorStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }
}
