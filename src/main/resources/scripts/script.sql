CREATE DATABASE carteira - cryptos;
USE carteira - cryptos;
CREATE TABLE `clientes` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `nome` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE `cryptos` (
   `codigo` varchar(255) NOT NULL,
   `nome` varchar(255) DEFAULT NULL,
   `valor` decimal(19, 2) DEFAULT NULL,
   `valor_compra` double DEFAULT NULL,
   `valor_venda` double DEFAULT NULL,
   PRIMARY KEY (`codigo`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE `crypto_cliente` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `quantidade` decimal(19, 2) DEFAULT NULL,
   `codigo_crypto` varchar(255) NOT NULL,
   `id_cliente` bigint DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `FK1kul24dxqaw1khwovo6v8lo6s` (`codigo_crypto`),
   KEY `FKd89jnh39hivt1nnobh36vc53p` (`id_cliente`),
   CONSTRAINT `FK1kul24dxqaw1khwovo6v8lo6s` FOREIGN KEY (`codigo_crypto`) REFERENCES `cryptos` (`codigo`),
   CONSTRAINT `FKd89jnh39hivt1nnobh36vc53p` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

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


