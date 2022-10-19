package br.com.fiap.carteiracryptosspring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "clientes")
public class Cliente implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "nome", nullable = false)
   private String nome;

   public Cliente(){};
   public Cliente(String nome) {
      this.nome = nome;
   }
   public Cliente(Long id, String nome){
      this.id = id;
      this.nome = nome;
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
}
