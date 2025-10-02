package br.com.fiap_esg.esg_fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"br.com.fiap_esg.esg_fiap"})
@EnableJpaRepositories(basePackages="br.com.fiap_esg.esg_fiap")
@EnableTransactionManagement
@EntityScan(basePackages="br.com.fiap_esg.esg_fiap")

public class EsgFiapApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsgFiapApplication.class, args);
	}

}
