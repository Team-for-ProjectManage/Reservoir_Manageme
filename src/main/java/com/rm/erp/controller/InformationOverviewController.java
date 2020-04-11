package com.rm.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.rm.erp.common.CommonResult;
import com.rm.erp.service.information.InformationOverviewService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.rm.erp.utils.ResponseJsonUtil.returnJson;

import java.util.*;

/**
 * @author ji_sheng_hua 华夏erp
 */
@RestController
@RequestMapping(value = "/information")
public class InformationOverviewController {

	@Resource
	private InformationOverviewService informationOverviewService;

	/**
	 * create by: cjl description: 新增用户及机构和用户关系 create time: 2019/3/8 16:06
	 * 
	 * @Param: beanJson
	 * @return java.lang.Object
	 */
	@RequestMapping(value="/getInfoData",method = RequestMethod.POST)
	@ResponseBody
	public CommonResult getInfoData() {
		return informationOverviewService.getInfoData();
	}
	
}
