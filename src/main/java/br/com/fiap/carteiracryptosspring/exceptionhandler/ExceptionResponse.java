package br.com.fiap.carteiracryptosspring.exceptionhandler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {
   private Date timestamp;
   private String mensagem;
   private String detalhes;
   private String httpCodeMessage;
}
