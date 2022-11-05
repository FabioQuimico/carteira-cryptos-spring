package br.com.fiap.carteiracryptosspring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
   
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "nome", nullable = false)
   private String nome;
   
   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @JsonManagedReference
   @OneToMany(
      mappedBy = "cliente", 
      fetch=FetchType.LAZY,
      cascade = CascadeType.ALL)
   private Set<CryptoCliente> cryptos = new HashSet<CryptoCliente>();

   public CryptoCliente buscaCrypto(String codigo) {
      for (CryptoCliente crypto : cryptos) {
         if (crypto.getCrypto().getCodigo().equalsIgnoreCase(codigo))
            return crypto;
      }
      return null;
   }
}
