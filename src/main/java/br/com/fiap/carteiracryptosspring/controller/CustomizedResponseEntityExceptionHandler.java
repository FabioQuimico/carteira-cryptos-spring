package br.com.fiap.carteiracryptosspring.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.fiap.carteiracryptosspring.exceptionhandler.ExceptionResponse;
import br.com.fiap.carteiracryptosspring.exceptionhandler.InsuficientFundsException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(InsuficientFundsException.class)
   public final ResponseEntity<ExceptionResponse> handleNotFoundException(InsuficientFundsException ex,
         WebRequest request) {
      ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
            request.getDescription(false), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());

      return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
   }
}