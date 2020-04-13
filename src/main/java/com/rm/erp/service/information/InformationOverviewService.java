package com.rm.erp.service.information;

import java.util.List;

import com.rm.erp.common.CommonResult;
import com.rm.erp.datasource.vo.InspectCheck;

public interface InformationOverviewService {

	CommonResult getInfoData();

	CommonResult getEchartsData(String hour);

	List<InspectCheck> getPotalCheckData();

	List<InspectCheck> getPotalCheckResk();

	List<InspectCheck> getTaskTableData(String startTime, String endTime);

}
