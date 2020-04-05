package com.rm.erp.service.organization;

import java.lang.annotation.*;

import com.rm.erp.service.ResourceInfo;

/**
 * Description
 *  机构
 * @Author: cjl
 * @Date: 2019/3/6 15:10
 */
@ResourceInfo(value = "organization", type = 1574002387)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrganizationResource {
}
