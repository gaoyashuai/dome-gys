package com.dome.config.exception;

import com.dome.param.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result bigExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("ex =>" + e);
        //全局异常处理逻辑
        if (e instanceof GlobalException) {
            return Result.error(((GlobalException) e).getCodeMsg());
        }
        //绑定异常处理逻辑
        else if (e instanceof BindException) {
            BindException exception = (BindException) e;
            List<ObjectError> errors = exception.getAllErrors();
            String msg = errors.get(0).getDefaultMessage();
            return Result.error(CodeMsg.SERVER_BIND_ERROR.fillArgs(msg));
        }
        return Result.error(CodeMsg.SERVER_ERROR);

    }

    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, GlobalException e) {
        log.error("ex =>" + e);
        // 异常处理逻辑
        Result result = new Result(e.getCodeMsg().getCode(), e.getMsg());
        return result;
    }
}