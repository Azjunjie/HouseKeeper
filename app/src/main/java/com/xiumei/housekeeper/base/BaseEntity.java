package com.xiumei.housekeeper.base;

/**
 * @des 封装的实体类的基类
 * Created by zjj on 2018/3/20 14:52.
 */
public class BaseEntity<T> {
    private String code;
    private String msg;
    private T t;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
