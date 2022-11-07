package br.com.fiap.carteiracryptosspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.carteiracryptosspring.model.CryptoCliente;

@Repository
public interface CryptoClienteRepository extends CrudRepository<CryptoCliente, Long> {

   // @Query("SELECT cc FROM CryptoCliente cc WHERE cc.cliente.id = :idCliente")
   // List<CryptoCliente> listaCryptosCliente(@Param("idCliente") Long idCliente);

}
