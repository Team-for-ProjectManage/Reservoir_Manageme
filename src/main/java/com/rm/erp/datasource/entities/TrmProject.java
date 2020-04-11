package com.rm.erp.datasource.entities;

import java.io.Serializable;
import java.util.Date;

public class TrmProject implements Serializable {
    private String id;

    private String name;

    private String code;

    private String projectGrade;

    private String projectContruction;

    private Date completeTime;

    private String highSystem;

    private Date checkTime;

    private String isComplete;

    private String remark;

    private Date ceateTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getProjectGrade() {
        return projectGrade;
    }

    public void setProjectGrade(String projectGrade) {
        this.projectGrade = projectGrade == null ? null : projectGrade.trim();
    }

    public String getProjectContruction() {
        return projectContruction;
    }

    public void setProjectContruction(String projectContruction) {
        this.projectContruction = projectContruction == null ? null : projectContruction.trim();
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getHighSystem() {
        return highSystem;
    }

    public void setHighSystem(String highSystem) {
        this.highSystem = highSystem == null ? null : highSystem.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete == null ? null : isComplete.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCeateTime() {
        return ceateTime;
    }

    public void setCeateTime(Date ceateTime) {
        this.ceateTime = ceateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}