package com.momentum.active.activeshoppe.advice;

import com.momentum.active.activeshoppe.exception.ActiveShoppeBadRequestException;
import com.momentum.active.activeshoppe.exception.ActiveShoppeResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ActiveShoppeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ActiveShoppeResourceNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(ActiveShoppeBadRequestException.class)
    public void springHandleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
