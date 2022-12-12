package com.corewell.study.service;

import com.corewell.study.domain.Decoder;
import com.corewell.study.domain.request.DecoderReq;
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
public interface DecoderService {
    /**
     * 查询设备
     *
     * @param decoderReq
     * @return
     */
    ResultMsg findDecoder(DecoderReq decoderReq);

    /**
     * 新增设备
     *
     * @param decoder
     * @return
     */
    ResultMsg insertDecoder(Decoder decoder);

    /**
     * 修改设备
     *
     * @param decoder
     * @return
     */
    ResultMsg updateDecoder(Decoder decoder);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    ResultMsg updateDecoderStatus(@Param("id") Long id);


}
