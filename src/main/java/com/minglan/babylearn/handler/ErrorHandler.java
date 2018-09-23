package com.minglan.babylearn.handler;

import com.minglan.babylearn.exception.BusinessException;
import com.minglan.babylearn.result.Result;
import com.minglan.babylearn.result.ResultMesg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ErrorHandler
 * 统一异常处理
 * 18/9/23 11:47
 * @author yangling
 * @version 1.0
 */

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        LOGGER.error("Catch Exception = {} ",e);
        if(e instanceof BusinessException) {
            return Result.error((BusinessException)e);
        }else{
            return Result.error(ResultMesg.SYS_ERR);
        }

    }

}
