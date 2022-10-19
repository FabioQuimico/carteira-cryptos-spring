package br.com.fiap.carteiracryptosspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "cryptos")
public class Crypto {
   
   @Id
   private String codigo;
   private String nome;

}
