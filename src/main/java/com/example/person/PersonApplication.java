package com.example.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// ↓ Indica que essa classe é responsável por acessar e manipular
// ↓ dados nobanco de dados ou em outra fonte de dados externa.
@SpringBootApplication
@EnableFeignClients
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}
}
