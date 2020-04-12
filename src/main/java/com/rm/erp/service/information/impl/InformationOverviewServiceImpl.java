package com.rm.erp.service.information.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rm.erp.common.CommonResult;
import com.rm.erp.common.CommonResultEnum;
import com.rm.erp.controller.InformationOverviewController;
import com.rm.erp.datasource.vo.InspectCheck;
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
			dataListMap.put("storageCapacity", "4355");
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

	@Override
	public CommonResult getEchartsData(String hour) {
		CommonResult result = new CommonResult();
		Map<String, Object> dataListMap = new HashMap<String, Object>();
		List<String> hourList = new ArrayList<String>();
		List<Integer> storageCapacityList = new ArrayList<Integer>();
		List<Integer> waterLevelList = new ArrayList<Integer>();
		try {
			for (int i = 0; i < Integer.parseInt(hour); i++) {
				hourList.add(String.valueOf(i + 1));
				storageCapacityList.add((int) (Math.random() * 50));
				waterLevelList.add((int) (Math.random() * 50));
			}
			dataListMap.put("hourList", hourList);
			dataListMap.put("storageCapacityList", storageCapacityList);
			dataListMap.put("waterLevelList", waterLevelList);

			result.setData(dataListMap);
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getEchartsData is fail:" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<InspectCheck> getPotalCheckData() {
		List<InspectCheck> reslutChecks = new ArrayList<InspectCheck>();
		SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 12; i++) {
			InspectCheck inspectCheck = new InspectCheck();
			inspectCheck.setId(String.valueOf(i + 1));
			inspectCheck.setCheckName("现场巡检" + i);
			inspectCheck.setCheckUser("老段" + i);
			inspectCheck.setStartTime(sdfDateFormat.format(new Date()));
			inspectCheck.setEndTime(sdfDateFormat.format(new Date()));
			inspectCheck.setRemark("老段备注" + i);
			reslutChecks.add(inspectCheck);
		}
		return reslutChecks;
	}

	@Override
	public List<InspectCheck> getPotalCheckResk() {
		List<InspectCheck> reslutChecks = new ArrayList<InspectCheck>();
		SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 6; i++) {
			InspectCheck inspectCheck = new InspectCheck();
			inspectCheck.setId(String.valueOf(i + 1));
			inspectCheck.setCheckName("巡检任务" + i);
			inspectCheck.setCheckUser("干大宝" + i);
			inspectCheck.setStartTime(sdfDateFormat.format(new Date()));
			inspectCheck.setEndTime(sdfDateFormat.format(new Date()));
			inspectCheck.setRemark("干大宝备注" + i);
			reslutChecks.add(inspectCheck);
		}
		return reslutChecks;
	}

}
