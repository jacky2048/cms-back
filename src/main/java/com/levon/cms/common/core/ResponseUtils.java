package com.levon.cms.common.core;

public class ResponseUtils {

    public static <T> RetResult<T> responseSuccess() {
        return new RetResult<T>().setRetResult(RetCodeMsgEnum.SUCCESS);
    }

    public static <T> RetResult<T> responseData(T data) {
        return new RetResult<T>().setRetResult(RetCodeMsgEnum.SUCCESS).setData(data);
    }

    public static <T> RetResult<T> responseFailure() {
        return new RetResult<T>().setRetResult(RetCodeMsgEnum.FAILURE);
    }

    public static <T> RetResult<T> responseError(String msg) {
        return new RetResult<T>().setRetResult(RetCodeMsgEnum.FAILURE).setMsg(msg);
    }

    public static <T> RetResult<T> responseResult(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> responseResult(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
