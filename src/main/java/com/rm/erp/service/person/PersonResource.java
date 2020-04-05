package com.rm.erp.service.person;

import java.lang.annotation.*;

import com.rm.erp.service.ResourceInfo;

/**
 * @author jishenghua qq752718920  2018-10-7 15:26:27
 */
@ResourceInfo(value = "person", type = 1574002402)
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonResource {
}
