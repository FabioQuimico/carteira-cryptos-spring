package br.com.fiap.carteiracryptosspring.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoDTO {
   String id;
   String codigo;
   String nome;
   String descricao;
   double cotacao_compra;
   double caotacao_venda;
   double variacao;
   Timestamp timestamp_atualizacao;
}
