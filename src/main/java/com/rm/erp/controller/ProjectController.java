package com.rm.erp.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rm.erp.common.CommonResult;
import com.rm.erp.datasource.entities.TrmProject;
import com.rm.erp.service.project.ProjectService;

/**
 * @author 邵战国
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

	@Resource
	private ProjectService projectService;

	/**
	 * 获得ehcart数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult save(@RequestParam("TrmProject") TrmProject project) {
		return projectService.save(project);
	}

	/**
	 * 获得ehcart数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult edit(@RequestParam("TrmProject") TrmProject project) {
		return projectService.edit(project);
	}

	/**
	 * 获得ehcart数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult delete(@RequestParam("id") String id) {
		return projectService.delete(id);
	}

	/**
	 * 获得首页信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getById(@RequestParam("id") String id) {
		return projectService.getById(id);
	}

	/**
	 * 获得首页信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getAll() {
		return projectService.getAll();
	}
}
