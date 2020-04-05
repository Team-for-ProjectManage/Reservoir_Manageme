package com.rm.erp.service.depot;

import java.lang.annotation.*;

import com.rm.erp.service.ResourceInfo;

/**
 * @author jishenghua qq752718920  2018-10-7 15:26:27
 */
@ResourceInfo(value = "depot", type = 1574002302)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DepotResource {
}
