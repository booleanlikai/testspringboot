package com.likai.gateway.Advice;

import com.likai.gateway.exception.myException;
import com.likai.gateway.model.baseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class ExampleAdvice1  {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAdvice1.class);

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public baseResponse fetchexception( Exception e) {
        e.printStackTrace();
        baseResponse baseResponse = new baseResponse("N001", "测试错误");
        return  baseResponse;
    }

    @ExceptionHandler({myException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public baseResponse fetchMyException(myException e) {
        e.printStackTrace();
        baseResponse baseResponse = new baseResponse(e.getRetCode(), e.getRetMsg());
        return baseResponse;
    }


}