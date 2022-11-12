package br.com.fiap.carteiracryptosspring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.carteiracryptosspring.dto.CryptoClienteDTO;
import br.com.fiap.carteiracryptosspring.exceptionhandler.ClienteNotFoundException;
import br.com.fiap.carteiracryptosspring.model.Cliente;
import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.service.AtualizaCryptosService;
import br.com.fiap.carteiracryptosspring.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

   @Autowired
   ClienteService service;
   @Autowired
   AtualizaCryptosService aService;
   
   @GetMapping("/lista")
   public List<Cliente> getClienteList() {
      return service.getClienteList();
   }
   
   @GetMapping("/{id}")
   public Cliente getClienteById(@PathVariable Long id) {

      try {
         aService.atualizaCryptos();
      } catch (Exception e) {
         System.out.println("*** NÃO FOI POSSIVEL ATUALIZAR A BASE, USANDO DADOS LOCAIS ***");
      }
      try {
         return service.getClienteById(id);
      } catch (Exception e) {
         throw new ClienteNotFoundException("Cliente não encontrado em nossa base de dados");
      }
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Cliente addCliente(@RequestBody Cliente cliente) {
      return service.saveCliente(cliente);
   }

   @PutMapping
   @ResponseStatus(HttpStatus.ACCEPTED)
   public Cliente alterar(@RequestBody Cliente alterar) {
      return service.alterarCliente(alterar);
   }

   @DeleteMapping("/{id}")
   public void deleteCliente(@PathVariable Long id) {
      service.deleteById(id);
   }

   @PostMapping("/{idCliente}/compra")
   public CryptoCliente compraCrypto(@PathVariable Long idCliente, @RequestBody CryptoClienteDTO compra) throws Exception {
      return service.compraCrypto(idCliente, compra);
   }

   @PostMapping("/{idCliente}/venda")
   public CryptoCliente vendeCrypto(@PathVariable Long idCliente, @RequestBody CryptoClienteDTO venda) throws Exception{
      return service.vendeCrypto(idCliente, venda);
   }

   @GetMapping("/{idCliente}/cryptos")
   public Set<CryptoCliente> listaCryptos(@PathVariable Long idCliente) {
      return service.getCryptosCliente(idCliente);
   }
}
