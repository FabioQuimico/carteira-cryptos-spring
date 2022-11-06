package br.com.fiap.carteiracryptosspring.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.carteiracryptosspring.dto.CryptoClienteDTO;
import br.com.fiap.carteiracryptosspring.exceptionhandler.CryptoNotFoundException;
import br.com.fiap.carteiracryptosspring.exceptionhandler.InsuficientFundsException;
import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.model.Crypto;
import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.repository.ClienteRepository;

@Service
public class ClienteService implements Serializable {

   private static final long serialVersionUID = 1L;

   @Autowired
   ClienteRepository repository;
   @Autowired
   CryptoClienteService ccService;
   @Autowired
   CryptoService cService;

   public List<Cliente> getClienteList() {
      return repository.findAll();
   }

   public Cliente getClienteById(Long id) {
      return repository.findById(id).get();
   }

   public Cliente saveCliente(Cliente cliente) {
      repository.save(cliente);
      return cliente;
   }

   public void deleteById(Long id) {
      repository.deleteById(id);
   }

   public Cliente alterarCliente(Cliente cliente) {
      return repository.save(cliente);
   }

   public CryptoCliente compraCrypto(Long idCliente, CryptoClienteDTO compra) throws Exception {

      Cliente cliente = repository.findById(idCliente).get();

      CryptoCliente cryptoPossuida = cliente.buscaCrypto(compra.getCodigo());
      if (cryptoPossuida != null) {
         System.out.println(" *** O CLIENTE JÁ POSSUI ESSA CRYPTO ***");
         cryptoPossuida.setQuantidade(cryptoPossuida.getQuantidade().add(compra.getQuantidade()));
         return ccService.saveCryptoCliente(cryptoPossuida);
      } else {
         System.out.println(" *** O CLIENTE NÃO POSSUIA ESSA CRYPTO ***");
         CryptoCliente cryptoCliente = new CryptoCliente();
         cryptoCliente.setCliente(cliente);

         // Verifica se a criptomoeda já existe na base
         Crypto crypto = cService.getCryptosById(compra.getCodigo());

         if (crypto == null) {
            // TODO: Atualiza base de cryptos
            System.out.println("*** AGUARDE ATUALIZANDO BASE DE CRIPTOMOEDAS... ***");
            crypto = cService.getCryptosById(compra.getCodigo());
            // Tenta novamente com a base atualizada
            if (crypto == null) {
               throw new CryptoNotFoundException("*** Criptomoeda não existe na base de dados ***");
            }
         } else {
            cryptoCliente.setCrypto(crypto);
            cryptoCliente.setQuantidade(compra.getQuantidade());
         }
         return ccService.saveCryptoCliente(cryptoCliente);
      }
   }

   public CryptoCliente vendeCrypto(Long idCliente, CryptoClienteDTO venda) throws Exception {

      Cliente cliente = repository.findById(idCliente).get();
      CryptoCliente cryptoPossuida = cliente.buscaCrypto(venda.getCodigo());

      if (cryptoPossuida != null) {
         if (venda.getQuantidade().compareTo(cryptoPossuida.getQuantidade()) < 0) {
            cryptoPossuida.setQuantidade(cryptoPossuida.getQuantidade().subtract(venda.getQuantidade()));
            ccService.saveCryptoCliente(cryptoPossuida);
         } else if (venda.getQuantidade().compareTo(cryptoPossuida.getQuantidade()) == 0){
            ccService.deleteCryptoCliente(cryptoPossuida);
            return null;
         } else {
            throw new InsuficientFundsException("*** Cliente não possui essa quantidade da criptomoeda! ***");   
         }
      } else {
         throw new Exception("*** Cliente não possui essa criptomoeda ***");
      }
      return cliente.buscaCrypto(venda.getCodigo());
   }
}