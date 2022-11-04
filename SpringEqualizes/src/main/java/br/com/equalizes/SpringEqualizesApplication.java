package br.com.equalizes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringEqualizesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEqualizesApplication.class, args);
		
		System.out.println("Aplicação rodando...");
		
	}

}
