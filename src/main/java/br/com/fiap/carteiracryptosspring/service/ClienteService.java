package br.com.fiap.carteiracryptosspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.carteiracryptosspring.dto.CryptoClienteDTO;
import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.repository.ClienteRepository;

@Service
public class ClienteService {
   
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

   public CryptoCliente compraCrypto(Long idCliente, CryptoClienteDTO compra) {

      Cliente cliente = repository.findById(idCliente).get();

      System.out.println(cliente.buscaCrypto(compra.getCodigo()));

      CryptoCliente cryptoPossuida = cliente.buscaCrypto(compra.getCodigo());
      if (cryptoPossuida != null) {
         System.out.println(" *** O CLIENTE JÁ POSSUI ESSA CRYPTO ***");
         cryptoPossuida.setQuantidade(cryptoPossuida.getQuantidade().add(compra.getQuantidade()));
         return ccService.saveCryptoCliente(cryptoPossuida);
      } else {
         System.out.println(" *** O CLIENTE NÃO POSSUIA ESSA CRYPTO ***");
         CryptoCliente cryptoCliente = new CryptoCliente();
         cryptoCliente.setCliente(cliente);
         cryptoCliente.setCrypto(cService.getCryptosById(compra.getCodigo()));
         cryptoCliente.setQuantidade(compra.getQuantidade());

         return ccService.saveCryptoCliente(cryptoCliente);
      }
   }
}
