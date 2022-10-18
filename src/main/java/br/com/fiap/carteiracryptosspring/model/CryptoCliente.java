package br.com.fiap.carteiracryptosspring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Quando transforma em entidade quebra
//@Entity
@Table(name = "crypto_cliente")
public class CryptoCliente implements Serializable{
   
   @ManyToOne(optional=false)
   @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
   Cliente cliente;
   
   @ManyToOne(optional=false)
   @JoinColumn(name = "codigoCrypto", referencedColumnName = "codigo", nullable = false)
   Crypto crypto;

   BigDecimal quantidade;

   public CryptoCliente() {
   }

   public CryptoCliente(Cliente cliente, Crypto crypto, BigDecimal quantidade) {
      this.cliente = cliente;
      this.crypto = crypto;
      this.quantidade = quantidade;
   }

   
}
