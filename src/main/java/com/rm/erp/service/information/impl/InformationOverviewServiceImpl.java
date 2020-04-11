package com.rm.erp.service.information.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rm.erp.common.CommonResult;
import com.rm.erp.common.CommonResultEnum;
import com.rm.erp.controller.InformationOverviewController;
import com.rm.erp.service.information.InformationOverviewService;
import com.rm.erp.utils.Tools;
import com.rm.erp.utils.WeatherHelper;

@Service
public class InformationOverviewServiceImpl implements InformationOverviewService {

	Logger logger = LoggerFactory.getLogger(InformationOverviewController.class);

	@Override
	public CommonResult getInfoData() {
		CommonResult result = new CommonResult();
		try {
			Map<String, Object> dataListMap = new HashMap<String, Object>();
			dataListMap.put("tatalPersion", "321");
			dataListMap.put("waterLevel", "778");
			dataListMap.put("StorageCapacity", "4355");
			dataListMap.put("dataTime", Tools.getNow());
			dataListMap.put("wather", WeatherHelper.getWatherByCity());
			dataListMap.put("week", Tools.getWeekDay());

			result.setData(dataListMap);
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

}
