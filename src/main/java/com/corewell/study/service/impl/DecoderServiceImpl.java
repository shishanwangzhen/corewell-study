package com.corewell.study.service.impl;

import com.corewell.study.dao.DecoderDao;
import com.corewell.study.domain.Decoder;
import com.corewell.study.domain.request.DecoderReq;
import com.corewell.study.domain.result.ResultMsg;
import com.corewell.study.domain.result.ResultStatusCode;
import com.corewell.study.service.DecoderService;
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
@Service("DecoderService")
public class DecoderServiceImpl implements DecoderService {

    @Autowired
    private DecoderDao decoderDao;

    @Override
    public ResultMsg findDecoder(DecoderReq decoderReq) {
        List<Decoder> decoderList = decoderDao.findDecoder(decoderReq);
        return ResultMsg.success(decoderList);
    }

    @Override
    public ResultMsg insertDecoder(Decoder decoder) {
        decoder.setCreateTime(new Date());
        decoder.setDeleteFlag("1");
        int result = decoderDao.insertDecoder(decoder);
        if (result == 1) {
            return ResultMsg.success();
        }
        return ResultMsg.error();
    }

    @Override
    public ResultMsg updateDecoder(Decoder decoder) {
        decoder.setUpdateTime(new Date());

        int result = decoderDao.updateDecoder(decoder);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.UPDATE_FAILED);
    }

    @Override
    public ResultMsg updateDecoderStatus(Long id) {
        int result = decoderDao.updateDecoderStatus(id);
        if (result == 1) {
            return ResultMsg.success();
        }
        return new ResultMsg(ResultStatusCode.DELETE_FAILED);
    }
}
