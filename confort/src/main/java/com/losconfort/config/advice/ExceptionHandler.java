package com.losconfort.config.advice;

import com.losconfort.confortstarterrest.config.advice.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler extends GlobalExceptionHandler {}
