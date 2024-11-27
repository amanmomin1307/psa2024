package com.crm.exception;

import com.crm.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice   //CATCH BLOCK
public class HandleException {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFound e, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), new Date(), request.getDescription(true)); //false will not show you the IP address
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> gloabalException(Exception e, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), new Date(), request.getDescription(false)); //false will not show you the IP address
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
