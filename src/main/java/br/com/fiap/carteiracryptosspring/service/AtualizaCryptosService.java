package br.com.fiap.carteiracryptosspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.carteiracryptosspring.dto.CryptoDTO;
import br.com.fiap.carteiracryptosspring.model.Crypto;

@Service
public class AtualizaCryptosService {

   @Autowired
   CryptoService service;

   public void atualizaCryptos() {
      String url = "http://localhost:5555/criptomoedas";
      RestTemplate restTemplate = new RestTemplate();

      CryptoDTO[] criptomoedasDTO = restTemplate.getForObject(url, CryptoDTO[].class);

      if ( criptomoedasDTO != null && criptomoedasDTO.length > 0 ) {
         // List<Crypto> cryptos = new ArrayList<Crypto>();

         for (CryptoDTO cryptoDTO : criptomoedasDTO) {
            Crypto crypto = new Crypto();
            crypto.setCodigo(cryptoDTO.getCodigo());
            crypto.setNome(cryptoDTO.getNome());
            crypto.setValorCompra(cryptoDTO.getCotacao_venda());
            crypto.setValorVenda(cryptoDTO.getCotacao_venda());
            service.insertCrypto(crypto);
            // cryptos.add(crypto);

         }
      }
   }
}
