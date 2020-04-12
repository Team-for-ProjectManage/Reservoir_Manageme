package com.rm.erp.service.project;

import com.rm.erp.common.CommonResult;
import com.rm.erp.datasource.entities.TrmProject;

public interface ProjectService {

	CommonResult save(TrmProject project);

	CommonResult edit(TrmProject project);

	CommonResult delete(String id);

	CommonResult getById(String id);

	CommonResult getAll();

}
