package br.com.fiap.carteiracryptosspring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "crypto_cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCliente implements Serializable {
   
   private static final long serialVersionUID = 1L;
   
   @Id
	@ManyToOne(optional=false)
   @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
   Cliente cliente;
   //Long idCliente;
   
   @Id
   @ManyToOne(optional=false)
   @JoinColumn(name = "codigoCrypto", referencedColumnName = "codigo", nullable = false)
   Crypto crypto;
   //String codigoCrypto;

   BigDecimal quantidade;
}
