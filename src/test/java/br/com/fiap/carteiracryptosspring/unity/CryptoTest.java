package br.com.fiap.carteiracryptosspring.unity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fiap.carteiracryptosspring.model.Crypto;

public class CryptoTest {
   
   Crypto crypto = new Crypto();
   
   @Test
   void deveCriarUmaCrypto (){
      crypto.setCodigo("ABC");
      crypto.setNome("Abc Coin");
      crypto.setValorCompra(1d);
      crypto.setValorVenda(2d);

      assertEquals(crypto.getCodigo(), "ABC");
      assertEquals(crypto.getValorCompra(), 1d);
      assertEquals(crypto.getValorVenda(), 2d);
      crypto.setValorVenda(1d);
      assertEquals(crypto.getValorVenda(), 1d);
   }
}
