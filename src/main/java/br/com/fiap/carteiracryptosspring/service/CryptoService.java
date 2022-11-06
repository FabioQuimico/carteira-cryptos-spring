package br.com.fiap.carteiracryptosspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.carteiracryptosspring.model.Crypto;
import br.com.fiap.carteiracryptosspring.repository.CryptoRepository;

@Service
public class CryptoService {
   
   @Autowired
   CryptoRepository repository;

   public List<Crypto> getCryptos() {
      return repository.findAll();
   }

   public Crypto getCryptosById(String codigo) {
      return repository.findById(codigo).orElse(null);
   }

   public Crypto insertCrypto(Crypto crypto) {
      return repository.save(crypto);
   }

   public void deleteCrypto(String codigo) {
      repository.deleteById(codigo);
   }
   
   
}
