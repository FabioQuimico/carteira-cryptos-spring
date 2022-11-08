# API de Carteira de Clientes de Criptomoedas

## Ferramentas utilizadas

- Java 17
  - Maven
  - SpringBoot
  - Junit
- MySQl
- Docker

## Execução

mvn clean install
mvn spring-boot:run

## Acesso à aplicação

localhost:8080

### Endpoints

- GET /cliente/lista: Lista todos os clientes cadastrados
- GET /cliente/{id}: Busca o cliente com {id} e suas criptomoedas
- POST /cliente: cadastra novo cliente recebido via Json
- PUT /cliente: altera cliente recebido via Json
- DELETE /cliente/{ìd}: Apaga cliente com {id}
- POST /cliente/{id}/compra: Cliente com {ìd} efetua compra de criptomoeda na quantidade passada via Json
- POST /cliente/{id}/venda: Cliente com {ìd} efetua venda de criptomoeda na quantidade passada via Json
- GET /cliente/{id}/cryptos: Lista todas as criptomoedas e quantidades do cliente com {id}

- GET /cryptos: Lista todas as criptomoedas da base de dados
- GET /crypto/{codigo}: Busca a criptomoeda com {codigo}
- POST /crypto/: Insere nova criptomoeda envia via Json
- DELETE /crypto/{codigo}: Apaga da base a criptomoeda com {codigo} (até buscar novamente via API externa)

### Formato dos parâmetros

Cliente

- id, numérico;
- nome, alfanumérico;
- cryptos, conjunto de criptomoedas, inicialmente vazio.

Crypto

- id, numérico;
- codigo, alfanumérico
- nome, alfanumérico
- valorCompra, double
- valorVenda, double
