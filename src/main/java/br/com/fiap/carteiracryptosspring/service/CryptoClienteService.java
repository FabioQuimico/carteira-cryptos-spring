package br.com.fiap.carteiracryptosspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.repository.CryptoClienteRepository;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class CryptoClienteService {

   @Autowired
   CryptoClienteRepository repository;

   // public List<CryptoCliente> getCryptosCliente(Long idCliente) {
   //    return repository.listaCryptosCliente(idCliente);
   // }

   public CryptoCliente saveCryptoCliente(CryptoCliente cryptoCliente) {
      return repository.save(cryptoCliente);
   }

   public void deleteCryptoCliente(CryptoCliente cryptoCliente) {
      repository.delete(cryptoCliente);
   }

   public void deleteById(Long id){
      repository.deleteById(id);
   }

}
