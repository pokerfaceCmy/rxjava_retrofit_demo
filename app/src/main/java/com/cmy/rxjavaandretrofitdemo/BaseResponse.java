package com.cmy.rxjavaandretrofitdemo;

/**
 * 文 件 名: BaseResponse<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:41<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:服务器返回数据基类<p>
 */
public class BaseResponse<T> {
    private static final int CODE_SUCCESS = 200;
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == CODE_SUCCESS;
    }

}
