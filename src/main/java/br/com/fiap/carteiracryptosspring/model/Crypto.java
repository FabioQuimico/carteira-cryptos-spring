package br.com.fiap.carteiracryptosspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cryptos")
public class Crypto {
   
   @Id
   private String codigo;

   private String nome;
   private Double valorCompra;
   private Double valorVenda;

}
