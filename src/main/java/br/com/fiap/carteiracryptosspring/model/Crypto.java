package br.com.fiap.carteiracryptosspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cryptos")
public class Crypto {
   
   @Id
   private String codigo;
   private String nome;

   public Crypto() {};
   public Crypto(String codigo, String nome) {
      this.codigo = codigo;
      this.nome = nome;
   }

   public String getcodigo() {
      return codigo;
   }
   public void setcodigo(String codigo) {
      this.codigo = codigo;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }

   

}
