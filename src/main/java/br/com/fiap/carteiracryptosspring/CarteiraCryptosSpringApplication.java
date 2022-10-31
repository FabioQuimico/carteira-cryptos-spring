package br.com.fiap.carteiracryptosspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
            title = "Carteiracryptosspring API",
            version = "1.0",
            description = "Carteiracryptosspring API"),
	servers = {
					@Server(url = "http://localhost:8080", description = "http://localhost:8080"),
				}
)
@SpringBootApplication
public class CarteiraCryptosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarteiraCryptosSpringApplication.class, args);
	}

}
