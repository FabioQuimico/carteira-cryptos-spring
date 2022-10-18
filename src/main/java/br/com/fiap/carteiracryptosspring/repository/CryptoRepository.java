package br.com.fiap.carteiracryptosspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.carteiracryptosspring.model.Crypto;

public interface CryptoRepository extends JpaRepository<Crypto, String> {
   
}
