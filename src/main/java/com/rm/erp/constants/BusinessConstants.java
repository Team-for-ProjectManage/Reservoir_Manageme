package com.rm.erp.constants;

/**
 * @ClassName:BusinessConstants
 * @Description 业务字典类
 * @Author qiankunpingtai
 * @Date 2019-3-6 17:58
 * @Version 1.0
 **/
public class BusinessConstants {

    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认的分页起始页页码
     */
    public static final Integer DEFAULT_PAGINATION_PAGE_NUMBER = 1;
    /**
     * 无数据时列表返回的默认数据条数
     */
    public static final Long DEFAULT_LIST_NULL_NUMBER = 0L;
    /**
     * 默认的分页条数
     */
    public static final Integer DEFAULT_PAGINATION_PAGE_SIZE = 10;
    
    /**
     * 删除标记 deleteFlag  '0'未删除 '1'已删除
     * */
    public static final String DELETE_FLAG_DELETED = "1";
    public static final String DELETE_FLAG_EXISTS = "0";
    /**
     * 批量插入sql时最大的数据条数
     * */
    public static final int BATCH_INSERT_MAX_NUMBER = 500;
    /**
     * 新增用户默认密码
     * */
    public static final String USER_DEFAULT_PASSWORD = "123456";
    /**
     * 用户是否系统自带
     * 0、非系统自带，1系统自带
     * */
    public static final byte USER_NOT_SYSTEM = 0;
    public static final byte USER_IS_SYSTEM = 1;
    /**
     * 用户是否为管理者
     * 0、管理者，1员工
     * */
    public static final byte USER_IS_MANAGER = 0;
    public static final byte USER_NOT_MANAGER = 1;
    /**
     * 用户状态
     * 0：正常，1：删除，2封禁
     * */
    public static final byte USER_STATUS_NORMAL = 0;
    public static final byte USER_STATUS_DELETE = 1;
    public static final byte USER_STATUS_BANNED = 2;

    /**
     * 数据数量单位
     * 条
     * */
    public static final String LOG_DATA_UNIT = "条";

    /**
     * 删除类型
     * 1正常删除
     * 2强制删除
     * */
    public static final String DELETE_TYPE_NORMAL = "1";
    public static final String DELETE_TYPE_FORCE = "2";

    /**
     * 默认管理员账号
     */
    public static final String DEFAULT_MANAGER = "admin";















}
