package com.minglan.babylearn.exception;

import com.minglan.babylearn.result.ResultMesg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BusinessException
 * 统一通用Exception
 * 18/9/23 11:47
 * @author yangling
 * @version 1.0
 */

public class BusinessException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);
    protected String code;

    public BusinessException(String code,String mesg) {
        super(mesg);
        this.code = code;
    }

    public BusinessException(ResultMesg resultMesg) {
        this(resultMesg.getCode(),resultMesg.getMesg());
    }

    public String getCode() {
        return code;
    }
}
