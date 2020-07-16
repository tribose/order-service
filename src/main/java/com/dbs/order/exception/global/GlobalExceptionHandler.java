package com.dbs.order.exception.global;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dbs.order.exception.OrderNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(OrderNotFoundException.class)
	public Object handleOrderNotFoundException(HttpServletRequest request, Exception ex) {
		logger.info("OrderNotFoundException Occured : "+request.getRequestURL());
		return "data not found error";
	}
}
