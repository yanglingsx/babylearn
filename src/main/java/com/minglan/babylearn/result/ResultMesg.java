package com.minglan.babylearn.result;

/**
 * ResultMesg
 * 错误信息枚举资源
 * 18/9/23 11:47
 * @author yangling
 * @version 1.0
 */

public enum ResultMesg {
    SYS_ERR("9999","系统错误"),
    TERR1("0001", "消息1"),
    TEERA2("00A2", "消息A2"),;

    private String code;
    private String mesg;

    ResultMesg(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

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
}
