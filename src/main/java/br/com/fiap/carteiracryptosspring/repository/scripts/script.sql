DROP DATABASE IF EXISTS carteira-cryptos;
CREATE DATABASE carteira-cryptos;
USE carteira-cryptos;

-- Tabela de Clientes
DROP TABLE IF EXISTS clientes;
CREATE TABLE `clientes` (
  `id` int NOT NULL,
  `nome` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `carteira-cryptos`.`clientes`
(`id`,
`nome`)
VALUES
(1,
"Gervasio");


-- Tabela contendo todas as Cryptos
CREATE TABLE `cryptos` (
  `codigo` varchar(10) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `carteira-cryptos`.`cryptos`
(`codigo`,
`nome`)
VALUES
("BTC",
"Bitcoin");

-- Tabela de ligação Cliente com Crypto
CREATE TABLE `crypto_cliente` (
  `idCliente` int NOT NULL,
  `codigoCrypto` varchar(45) NOT NULL,
  `quantidade` double DEFAULT NULL,
  PRIMARY KEY (`idCliente`,`codigoCrypto`),
  KEY `codigo_idx` (`codigoCrypto`),
  CONSTRAINT `codigo` FOREIGN KEY (`codigoCrypto`) REFERENCES `cryptos` (`codigo`),
  CONSTRAINT `id` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `carteira-cryptos`.`crypto_cliente`
(`idCliente`,
`codigoCrypto`,
`quantidade`)
VALUES
(1,
"BTC",
7.0);


