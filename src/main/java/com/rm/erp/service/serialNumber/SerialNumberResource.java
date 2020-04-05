package com.rm.erp.service.serialNumber;

import java.lang.annotation.*;

import com.rm.erp.service.ResourceInfo;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/1/21 16:33
 */
@ResourceInfo(value = "serialNumber", type = 1574002422)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNumberResource {
}
