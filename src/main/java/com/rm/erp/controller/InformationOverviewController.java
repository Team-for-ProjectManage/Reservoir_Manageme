package com.rm.erp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rm.erp.common.CommonResult;
import com.rm.erp.datasource.vo.InspectCheck;
import com.rm.erp.service.information.InformationOverviewService;

/**
 * @author 邵战国
 */
@RestController
@RequestMapping(value = "/information")
public class InformationOverviewController {

	@Resource
	private InformationOverviewService informationOverviewService;

	/**
	 * 获得首页信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getInfoData", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult getInfoData() {
		return informationOverviewService.getInfoData();
	}

	/**
	 * 获得ehcart数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getEchartsData", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult getEchartsData(@RequestParam("hour") String hour) {
		return informationOverviewService.getEchartsData(hour);
	}

	/**
	 * 获得巡检记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getPotalCheckData", method = RequestMethod.GET)
	@ResponseBody
	public List<InspectCheck> getPotalCheckData() {
		return informationOverviewService.getPotalCheckData();
	}

	/**
	 * 获得巡检任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getPotalCheckResk", method = RequestMethod.GET)
	@ResponseBody
	public List<InspectCheck> getPotalCheckResk() {
		return informationOverviewService.getPotalCheckResk();
	}

}
