package com.corewell.study.service.impl;

import com.corewell.study.dao.CollectorDao;
import com.corewell.study.domain.Collector;
import com.corewell.study.domain.request.CollectorReq;
import com.corewell.study.domain.result.ResultMsg;
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
    public ResultMsg findCollector(CollectorReq agreementReq) {
        List<Collector> CollectorList = CollectorDao.findCollector(agreementReq);
        return ResultMsg.success(CollectorList);
    }

    @Override
    public ResultMsg insertCollector(Collector Collector) {
        Collector.setCreateTime(new Date());
        Collector.setDeleteFlag("1");
        int result = CollectorDao.insertCollector(Collector);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateCollector(Collector Collector) {
        Collector.setUpdateTime(new Date());

        int result = CollectorDao.updateCollector(Collector);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateCollectorStatus(Long id) {
        int result = CollectorDao.updateCollectorStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }
}
