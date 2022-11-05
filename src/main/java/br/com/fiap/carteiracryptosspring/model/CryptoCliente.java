package br.com.fiap.carteiracryptosspring.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity(name = "crypto_cliente")
@Data
public class CryptoCliente {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @JsonIgnoreProperties
   @JsonBackReference
	@ManyToOne(optional=false)
   @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
   Cliente cliente;
   
   @ManyToOne(optional=false)
   @JoinColumn(name = "codigoCrypto", referencedColumnName = "codigo", nullable = false)
   Crypto crypto;

   BigDecimal quantidade;
}
