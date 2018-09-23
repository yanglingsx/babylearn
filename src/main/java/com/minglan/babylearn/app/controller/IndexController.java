package com.minglan.babylearn.app.controller;

import com.minglan.babylearn.exception.BusinessException;
import com.minglan.babylearn.result.Result;
import com.minglan.babylearn.result.ResultMesg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IndexController {

    @GetMapping(value = "hello")
    public Result hello() {
        return Result.error(ResultMesg.TEERA2);
    }

    @GetMapping(value = "read")
    public Result hello1() {
        return Result.success(ResultMesg.TEERA2);
    }

    @GetMapping(value = "test")
    public Result hello2(){
        return Result.error(ResultMesg.TERR1);
    }

    @GetMapping(value = "exc")
    public Result exc() throws Exception {
        throw new Exception("Base Exception");
    }

    @GetMapping(value = "be")
    private Result excb() {
        throw new BusinessException(ResultMesg.TERR1);
    }
}
