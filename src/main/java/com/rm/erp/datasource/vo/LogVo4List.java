package com.rm.erp.datasource.vo;

import com.rm.erp.datasource.entities.Log;

public class LogVo4List extends Log {

    private String username;

    private String createTimeStr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}