package com.levon.cms.common.core;

public class RetResult<T> {

    private int code;
    private String msg;
    private T data;

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setRetResult(RetCodeMsgEnum codeEnum) {
        this.code = codeEnum.code;
        this.msg = codeEnum.msg;
        return this;
    }
}
