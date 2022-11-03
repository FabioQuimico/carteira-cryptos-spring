package br.com.fiap.carteiracryptosspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.carteiracryptosspring.model.CryptoCliente;
import br.com.fiap.carteiracryptosspring.service.CryptoClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cryptocliente")
public class CryptoClienteController {

   @Autowired
   CryptoClienteService service;

   // @GetMapping("/lista/{idCliente}")
   // public List<CryptoCliente> listaCryptoCliente(@PathVariable Long idCliente) {
   //    return service.getCryptosCliente(idCliente);
   //}
   
}
