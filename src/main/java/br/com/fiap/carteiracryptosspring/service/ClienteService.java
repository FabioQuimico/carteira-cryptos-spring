package br.com.fiap.carteiracryptosspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.repository.ClienteRepository;

@Service
public class ClienteService {
   
   @Autowired
   ClienteRepository repository;

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
}
