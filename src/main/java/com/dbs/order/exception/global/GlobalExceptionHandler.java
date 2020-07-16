package com.dbs.order.exception.global;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dbs.order.exception.OrderItemNotFoundException;
import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.exception.bean.ErrorDetails;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

	@Autowired
	ErrorDetails errorDetails;
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
		logger.info("OrderNotFoundException Occured At: "+request.getContextPath());
		
		errorDetails.setTimestamp(new Date());
		errorDetails.setDetails(request.getDescription(true));
		errorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(OrderItemNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderItemNotFoundException(OrderItemNotFoundException ex, WebRequest request) {
		logger.info("OrderItemNotFoundException Occured At: "+request.getContextPath());
		
		errorDetails.setTimestamp(new Date());
		errorDetails.setDetails(request.getDescription(true));
		errorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);	
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", status.value());

        List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

        responseBody.put("errors", errors);

        return new ResponseEntity<>(responseBody, headers, status);

    }
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> constraintViolationException(ConstraintViolationException exception, WebRequest request) throws IOException {
		
		errorDetails.setTimestamp(new Date());
		errorDetails.setDetails(request.getDescription(false));
		errorDetails.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);	
    }
}
