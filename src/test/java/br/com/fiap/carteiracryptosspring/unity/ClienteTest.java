package br.com.fiap.carteiracryptosspring.unity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fiap.carteiracryptosspring.model.Cliente;

public class ClienteTest {
   
   Cliente cliente = new Cliente();
   
   @Test
   void clienteDeveSerCriado(){
      cliente.setId(1L);
      cliente.setNome("Roberval");
      cliente.setCryptos(null);

      assertEquals(cliente.getId(), 1L);
      assertEquals(cliente.getNome(), "Roberval");
      assertEquals(cliente.getCryptos(), null);
   }
}
