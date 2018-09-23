package com.minglan.babylearn.result;

import com.minglan.babylearn.exception.BusinessException;

/**
 * Result
 * 统一返回结果
 * 18/9/23 11:47
 * @author yangling
 * @version 1.0
 */

public class Result {

    private Integer ret;
    private String code;
    private String mesg;
    private Object data;

    public Result(String code, String mesg) {

        this.code = code;
        try {
            this.ret = Integer.parseInt(this.code);
        }catch (NumberFormatException e) {
            this.ret = -1;
        }
        this.mesg = mesg;
        this.data = null;
    }

    public Result(BusinessException e) {
        this(e.getCode(),e.getMessage());
    }

    public Result(ResultMesg resultMesg) {
        this(resultMesg.getCode(),resultMesg.getMesg());
    }

    public Result(Object data) {
        this.ret=0;
        this.code = "0000";
        this.mesg = "处理成功";
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result error(ResultMesg resultMesg) {
        return new Result(resultMesg);
    }

    public static Result error(BusinessException e) {return new Result(e);}

    public Integer getRet() { return ret; }

    public void setRet(Integer ret) { this.ret = ret; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", mesg='" + mesg + '\'' +
                ", data=" + data +
                '}';
    }
}
