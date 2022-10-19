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
import br.com.fiap.carteiracryptosspring.service.CryptoService;

@RestController
@RequestMapping("")
public class CryptoController {
   
   @Autowired
   CryptoService service;

   @GetMapping
   public List<Crypto> getCryptos() {
      return service.getCryptos();
   }

   @GetMapping("/crypto/{codigo}")
   public Crypto getCryptosById(@PathVariable String codigo) {
      return service.getCryptosById(codigo);
   }

   @PostMapping("/crypto")
   public Crypto insertCryptos(@RequestBody Crypto crypto) {
      return service.insertCryptos(crypto);
   }

   @DeleteMapping("/crypto/{codigo}")
   public void deleteCryptos(@PathVariable String codigo) {
      service.deleteCrypto(codigo);
   }
   
}
