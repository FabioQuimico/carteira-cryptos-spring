#Container 2: Aplicação Carteira-Cryptos
# Usando o jdk como base para execução
FROM openjdk

# WORKDIR /usr/src/app

COPY target/carteira-cryptos-spring-0.0.1-SNAPSHOT.jar carteira-cryptos.jar

# ENTRYPOINT ["java", "-jar", "carteira-cryptos.jar"]
CMD ["java", "-jar" "carteira-cryptos.jar"]
EXPOSE 8080

ENV spring.datasource.url=jdbc:h2:~/fiap/carteira-cryptos;DB_CLOSE_ON_EXIT=FALSE
ENV spring.datasource.username=root
ENV spring.datasource.password=root
ENV spring.datasource.driver-class-name=org.h2.Driver
ENV spring.h2.console.path=/h2
ENV spring.h2.console.enabled=true