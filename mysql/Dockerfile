# Container 1 : MySQL
# Derivando da imagem oficial do MySQL
FROM mysql:5.7
# Adicionando os scripts SQL para serem executados na criação do banco
COPY ./CreateDatabase.sql /docker-entrypoint-initdb.d/
COPY ./data.sql /docker-entrypoint-initdb.d/
#Porta padrão mySql
EXPOSE 3306