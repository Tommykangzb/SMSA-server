package com.example.campus.util;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;

    private String message;

    private  T data;
    private Result(){
        this.code = 200;
        this.message = "ok";
        this.data = null;
    }
    private Result(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 暴露外面静态方法. 成功
     */
    public static <E> Result success(E data){
        return new Result<E>(ResultCode.SUCCESS,data);
    }

    /**
     * 失败
     */
    public static <E> Result fail(E data){
        return new Result<E>(ResultCode.FAIL,data);
    }
//    //响应码
//    private int code;
//    private Object object;
//    public Result(int code,Object object) {
//        this.code = code;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public Object getObject() {
//        return object;
//    }
//
//    public void setObject(Object object) {
//        this.object = object;
//    }
}