package com.levon.cms.common.core;

public enum RetCodeMsgEnum {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAILURE(400, "失败"),
    /**
     * 没有权限
     */
    UNAUTHORIZED(401, "未授权"),
    /**
     * 页面未找到
     */
    NOT_FOUND(404, "页面丢失啦"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器异常");

    public int code;
    public String msg;

    RetCodeMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
