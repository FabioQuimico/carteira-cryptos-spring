package br.com.fiap.carteiracryptosspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.carteiracryptosspring.dto.CryptoDTO;
import br.com.fiap.carteiracryptosspring.model.Crypto;

@RestController
@RequestMapping("/atualiza")
public class AtualizaCryptosController {

   @GetMapping
   public List<Crypto> atualizaCryptos() {
      String url = "http://localhost:5555/criptomoedas";
      RestTemplate restTemplate = new RestTemplate();

      CryptoDTO[] criptomoedasDTO = restTemplate.getForObject(url, CryptoDTO[].class);

      if ( criptomoedasDTO != null && criptomoedasDTO.length > 0 ) {
         List<Crypto> cryptos = new ArrayList<Crypto>();

         for (CryptoDTO cryptoDTO : criptomoedasDTO) {
            Crypto crypto = new Crypto();
            crypto.setCodigo(cryptoDTO.getCodigo());
            crypto.setNome(cryptoDTO.getNome());
            cryptos.add(crypto);
         }
         return cryptos;
      }
      return null;
   }
}
