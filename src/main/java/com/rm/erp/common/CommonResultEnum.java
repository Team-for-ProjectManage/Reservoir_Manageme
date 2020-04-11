package com.rm.erp.common;

public enum CommonResultEnum {

	UNKNOWN_ERROR("0", "失败"),

    SUCCESS("200", "成功"),

    PARAM_ERROR("201", "参数不合法"),

    DATABASE_ERROR("202", "数据库异常");


    private String code;
    
    private String message;

    CommonResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
}
