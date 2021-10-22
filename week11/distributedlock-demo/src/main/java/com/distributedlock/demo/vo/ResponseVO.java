package com.distributedlock.demo.vo;

/**
 * @author ：minjian
 * @version ：V1.0.7
 * @program ：vevor-bmp
 * @date: 2020/8/11 17:52
 * @description ：
 */
public class ResponseVO<T> {
    private int code;
    private String message;
    //返回内容
    private T data;

    public ResponseVO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
