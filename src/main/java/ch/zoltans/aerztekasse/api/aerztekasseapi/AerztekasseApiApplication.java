package ch.zoltans.aerztekasse.api.aerztekasseapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info =
        @io.swagger.v3.oas.annotations.info.Info(
            title = "Aerztekasse API",
            version = "1.0",
            description = "Aerztekasse Demo API Documentation"),
    servers =
        @io.swagger.v3.oas.annotations.servers.Server(description = "Aerztekasse API", url = "/"))
@SpringBootApplication
public class AerztekasseApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AerztekasseApiApplication.class, args);
  }
}
