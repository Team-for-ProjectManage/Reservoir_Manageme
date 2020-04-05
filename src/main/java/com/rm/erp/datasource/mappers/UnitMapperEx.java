package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.Unit;

import java.util.Date;
import java.util.List;

public interface UnitMapperEx {

    List<Unit> selectByConditionUnit(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUnit(
            @Param("name") String name);

    int batchDeleteUnitByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}