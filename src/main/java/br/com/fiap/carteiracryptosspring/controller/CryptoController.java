package br.com.fiap.carteiracryptosspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.carteiracryptosspring.model.Crypto;
import br.com.fiap.carteiracryptosspring.repository.CryptoRepository;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {
   
   @Autowired
   CryptoRepository repository;

   @GetMapping
   public List<Crypto> getCryptos() {
      return repository.findAll();
   }

   @GetMapping("/{codigo}")
   public Crypto getCryptosById(@PathVariable String codigo) {
      return repository.findById(codigo).orElse(null);
   }

   @PostMapping("/insere")
   public Crypto insertCryptos(@RequestBody Crypto crypto) {
      return repository.save(crypto);
   }

   @DeleteMapping("/{codigo}")
   public void deleteCryptos(@PathVariable String codigo) {
      repository.deleteById(codigo);
   }
   
}
