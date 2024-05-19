package org.giriraj.Exceptions;

import java.time.LocalDateTime;

import org.giriraj.Controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	//	private PasswordEncoder pc;
	public static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(NotAvailableException.class)
	public ResponseEntity<MyErrorDetails> notAvail(NotAvailableException e, WebRequest we) {

         log.error(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> notFound(NotFoundException e, WebRequest we) {
		log.error(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> notException(Exception e, WebRequest we) {
		log.error(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandler(NoHandlerFoundException e, WebRequest we) {
		log.error(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodValid(MethodArgumentNotValidException e, WebRequest we) {
		log.error(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), "No Valid Entries", we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
}
