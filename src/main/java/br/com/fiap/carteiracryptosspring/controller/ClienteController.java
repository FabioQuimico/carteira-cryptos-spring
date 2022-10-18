package br.com.fiap.carteiracryptosspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.repository.ClienteRepository;

@RestController
//@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

   @Autowired
   ClienteRepository repository;
   
   @GetMapping
   public List<Cliente> getClienteList() {
      return repository.findAll();
   }
   
   @GetMapping("/busca/{id}")
   public Optional<Cliente> getClienteById(@PathVariable Long id) {
//      return repository.findById(id).orElse(new Cliente());
      return repository.findById(id);
   }

   @PostMapping("/insere")
   @ResponseStatus(HttpStatus.CREATED)
   public Cliente addCliente(@RequestBody Cliente cliente) {
      return repository.save(cliente);
   }

   @DeleteMapping("/delete/{id}")
   public void deleteCliente(@PathVariable Long id) {
      repository.deleteById(id);
   }
}
