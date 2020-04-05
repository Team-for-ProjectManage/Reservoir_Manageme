package com.rm.erp.service.systemConfig;

import java.lang.annotation.*;

import com.rm.erp.service.ResourceInfo;

/**
 * @author jishenghua qq752718920  2018-10-7 15:26:27
 */
@ResourceInfo(value = "systemConfig", type = 1574002437)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemConfigResource {
}
