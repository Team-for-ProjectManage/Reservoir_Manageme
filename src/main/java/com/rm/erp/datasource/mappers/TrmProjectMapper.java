package com.rm.erp.datasource.mappers;

import com.rm.erp.datasource.entities.TrmProject;

public interface TrmProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrmProject record);

    int insertSelective(TrmProject record);

    TrmProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TrmProject record);

    int updateByPrimaryKey(TrmProject record);
}