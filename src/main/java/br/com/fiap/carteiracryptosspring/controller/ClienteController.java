package br.com.fiap.carteiracryptosspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.carteiracryptosspring.dto.CryptoClienteDTO;
import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

   @Autowired
   ClienteService service;
   
   @GetMapping("/lista")
   public List<Cliente> getClienteList() {
      return service.getClienteList();
   }
   
   @GetMapping("/{id}")
   public Cliente getClienteById(@PathVariable Long id) {
      return service.getClienteById(id);
   }

   @PostMapping("/insere")
   @ResponseStatus(HttpStatus.CREATED)
   public Cliente addCliente(@RequestBody Cliente cliente) {
      return service.saveCliente(cliente);
   }

   @PutMapping("/altera")
   @ResponseStatus(HttpStatus.ACCEPTED)
   public Cliente alterar(@RequestBody Cliente alterar) {
      return service.alterarCliente(alterar);
   }

   @DeleteMapping("/{id}")
   public void deleteCliente(@PathVariable Long id) {
      service.deleteById(id);
   }

   @PostMapping("/{idCliente}/compra")
   public CryptoCliente compraCrypto(@PathVariable Long idCliente, @RequestBody CryptoClienteDTO compra) {

      return service.compraCrypto(idCliente, compra);
   }
}
