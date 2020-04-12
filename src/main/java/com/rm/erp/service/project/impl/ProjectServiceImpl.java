package com.rm.erp.service.project.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rm.erp.common.CommonResult;
import com.rm.erp.common.CommonResultEnum;
import com.rm.erp.controller.InformationOverviewController;
import com.rm.erp.datasource.entities.TrmProject;
import com.rm.erp.datasource.mappers.TrmProjectMapper;
import com.rm.erp.service.project.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	Logger logger = LoggerFactory.getLogger(InformationOverviewController.class);

	private TrmProjectMapper trmProjectMapper;

	@Override
	public CommonResult save(TrmProject project) {
		CommonResult result = new CommonResult();
		try {
			project.setId(UUID.randomUUID().toString().replace("-", ""));
			result.setData(trmProjectMapper.insertSelective(project));
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

	@Override
	public CommonResult edit(TrmProject project) {
		CommonResult result = new CommonResult();
		try {
			result.setData(trmProjectMapper.updateByPrimaryKeySelective(project));
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

	@Override
	public CommonResult delete(String id) {
		CommonResult result = new CommonResult();
		try {
			result.setData(trmProjectMapper.deleteByPrimaryKey(id));
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

	@Override
	public CommonResult getById(String id) {
		CommonResult result = new CommonResult();
		try {
			result.setData(trmProjectMapper.selectByPrimaryKey(id));
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

	@Override
	public CommonResult getAll() {
		CommonResult result = new CommonResult();
		try {
			result.setData(trmProjectMapper.selectAll());
			result.setStatus(CommonResultEnum.SUCCESS.getCode());
		} catch (Exception e) {
			result.setMsg(CommonResultEnum.UNKNOWN_ERROR.getMessage());
			result.setStatus(CommonResultEnum.UNKNOWN_ERROR.getCode());
			logger.error("InformationOverviewServiceImpl >> getInfoData is fail:" + e.getMessage());
		}
		return result;
	}

}
