package br.com.fiap.carteiracryptosspring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "crypto_cliente")
 @Data
// @NoArgsConstructor
// @AllArgsConstructor
public class CryptoCliente {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

	@ManyToOne(optional=false)
   @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
   Cliente cliente;
   
   @ManyToOne(optional=false)
   @JoinColumn(name = "codigoCrypto", referencedColumnName = "codigo", nullable = false)
   Crypto crypto;

   BigDecimal quantidade;
}
