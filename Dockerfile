#Container 2: Aplicação Carteira-Cryptos
# Usando o jdk como base para execução
FROM openjdk

# WORKDIR /usr/src/app

COPY target/carteira-cryptos-spring-0.0.1-SNAPSHOT.jar carteira-cryptos.jar

ENTRYPOINT ["java", "-jar", "carteira-cryptos.jar"]

EXPOSE 8080