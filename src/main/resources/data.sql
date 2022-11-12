INSERT INTO `carteira-cryptos`.`clientes` (`id`,`nome`)
VALUES ('1', 'Fabio');
INSERT INTO `carteira-cryptos`.`clientes` (`id`,`nome`)
VALUES ('1', 'Alexandre');
INSERT INTO `carteira-cryptos`.`clientes` (`id`,`nome`)
VALUES ('1', 'Rafael');
INSERT INTO `carteira-cryptos`.`clientes` (`id`,`nome`)
VALUES ('1', 'Gabriel');

INSERT INTO `carteira-cryptos`.`cryptos`
(`codigo`,
`nome`,
`valor_compra`,
`valor_venda`)
VALUES
('LUNA', 'Luna', '12', '12'
);

INSERT INTO `carteira-cryptos`.`crypto_cliente`
(`id`, `quantidade`, `codigo_crypto`, `id_cliente`)
VALUES
('1', '100.00', 'LUNA', '1');