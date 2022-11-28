package com.corewell.study.dao;

import com.corewell.study.domain.Decoder;
import com.corewell.study.domain.request.DecoderReq;
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
public interface DecoderDao {
    /**
     * 查询设备
     *
     * @param decoderReq
     * @return
     */
    List<Decoder> findDecoder(DecoderReq decoderReq);

    /**
     * 新增设备
     *
     * @param decoder
     * @return
     */
    int insertDecoder(Decoder decoder);

    /**
     * 修改设备
     *
     * @param decoder
     * @return
     */
    int updateDecoder(Decoder decoder);

    /**
     * 删除设备
     *
     * @param id
     * @return
     */
    int updateDecoderStatus(@Param("id") Long id);


}
