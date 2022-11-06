package br.com.fiap.carteiracryptosspring.exceptionhandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsuficientFundsException extends RuntimeException {
   public InsuficientFundsException(String message) {
      super(message);
   }
}
