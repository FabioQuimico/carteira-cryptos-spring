package br.com.fiap.carteiracryptosspring.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CryptoClienteDTO {
   
   private String codigo;
   private BigDecimal quantidade;
}
