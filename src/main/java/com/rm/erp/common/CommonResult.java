package com.rm.erp.common;

public class CommonResult {

	private String status; 
	
	private String msg;

	private Object data; 

	public CommonResult() {
		super();
	}

	public CommonResult(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public CommonResult(String status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public CommonResult(String status, String data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	} 
	
	
}
