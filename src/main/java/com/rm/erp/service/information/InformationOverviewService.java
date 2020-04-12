package com.rm.erp.service.information;

import com.rm.erp.common.CommonResult;

public interface InformationOverviewService {

	CommonResult getInfoData();

	CommonResult getEchartsData(String hour);

}
