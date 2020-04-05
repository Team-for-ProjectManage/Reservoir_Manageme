package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.Role;

import java.util.Date;
import java.util.List;

public interface RoleMapperEx {

    List<Role> selectByConditionRole(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByRole(
            @Param("name") String name);

    int batchDeleteRoleByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}