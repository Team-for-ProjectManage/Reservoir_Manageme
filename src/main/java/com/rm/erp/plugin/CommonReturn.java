package com.rm.erp.plugin;

/**
 * 插件之间互相调用的类
 */
public class CommonReturn {

    private String returnName;
    private Boolean result;

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CommonReturn{" +
                "returnName='" + returnName + '\'' +
                ", result=" + result +
                '}';
    }
}
