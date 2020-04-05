package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.Person;

import java.util.Date;
import java.util.List;

public interface PersonMapperEx {

    List<Person> selectByConditionPerson(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByPerson(
            @Param("name") String name,
            @Param("type") String type);

    int batchDeletePersonByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}