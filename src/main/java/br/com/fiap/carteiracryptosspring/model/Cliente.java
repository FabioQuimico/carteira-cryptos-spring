package br.com.fiap.carteiracryptosspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "clientes")
public class Cliente {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "nome", nullable = false)
   private String nome;
   @Column(name = "email", nullable = false)
   private String email;

   public Cliente(){};
   public Cliente(String nome, String email) {
      this.nome = nome;
      this.email = email;
   }
   public Cliente(Long id, String nome, String email){
      this.id = id;
      this.nome = nome;
      this.email = email;
   }
   public void setID(Long id) {
      this.id = id;
   }
   public Long getId() {
      return id;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public String getNome() {
      return nome;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getEmail() {
      return email;
   }

}
