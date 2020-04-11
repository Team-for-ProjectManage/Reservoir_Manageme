package com.rm.erp.datasource.mappers;

import com.rm.erp.datasource.entities.TrmProjectDetail;

public interface TrmProjectDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrmProjectDetail record);

    int insertSelective(TrmProjectDetail record);

    TrmProjectDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TrmProjectDetail record);

    int updateByPrimaryKey(TrmProjectDetail record);
}