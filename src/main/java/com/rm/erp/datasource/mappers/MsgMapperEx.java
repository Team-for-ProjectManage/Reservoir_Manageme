package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.Msg;

import java.util.List;

public interface MsgMapperEx {

    List<Msg> selectByConditionMsg(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMsg(
            @Param("name") String name);

    int batchDeleteMsgByIds(@Param("ids") String ids[]);

    int insertSelectiveByTask(Msg record);

    int checkIsNameExistByTask(@Param("msgTitle") String msgTitle);

    Long getMsgCountByStatus(
            @Param("status") String status,
            @Param("userId") Long userId);
}