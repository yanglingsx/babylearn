package com.minglan.babylearn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * LogAspect
 * 日志记录，AOP切面编程方式
 * 18/9/23 11:20
 * @author yangling
 * @version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /* 定义切面 */
    @Pointcut("execution(public * com.minglan.babylearn..*(..))")
    public void siteLog(){}

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 接入起记录日志 参数为joinPoing 切面
     */
    @Before("siteLog()")
    public void doBefore(JoinPoint joinPoint){

        startTime.set(System.currentTimeMillis());

        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;
        request = attributes.getRequest();
        HttpSession session = request.getSession();
        // 记录下请求内容
        LOGGER.info("Receive a call from client \nURL : {} \nHTTP_METHOD : {}\nCLIENT_IP : {}\nCLASS_METHOD : {}\nARGS : {}" ,
                request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @After("siteLog()")
    public void doAfter() {
        LOGGER.info("After call ");
        LOGGER.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();//用完之后记得清除，不然可能导致内存泄露;
    }

    @AfterReturning(returning = "ret", pointcut = "siteLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        LOGGER.info("AfterReturn , RESPONSE : {}", ret);
    }

}
