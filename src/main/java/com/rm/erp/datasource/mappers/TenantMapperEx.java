package com.rm.erp.datasource.mappers;

import org.apache.ibatis.annotations.Param;

import com.rm.erp.datasource.entities.Tenant;

import java.util.List;

public interface TenantMapperEx {

    List<Tenant> selectByConditionTenant(
            @Param("loginName") String loginName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByTenant(
            @Param("loginName") String loginName);
}