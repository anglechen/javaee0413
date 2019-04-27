package com.test.other;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler{
  
    //400错误
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String requestMissingServletRequest(Exception ex){
        System.out.println("500..MissingServletRequest");
        ex.printStackTrace();
        return ReturnFormat.retParam(500, null);
    }
    
    
    
    
    
    
  
    //500错误
//    @ExceptionHandler({Exception.class})
//    @ResponseBody
   /* public String server500(RuntimeException runtimeException){
        System.out.println("500...");
        return ReturnFormat.retParam(500, null);
    }*/
}