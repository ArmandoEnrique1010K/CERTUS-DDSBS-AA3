package com.edu.certus.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("com.edu.certus.curso.client")
@SpringBootApplication
public class MsCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCursoApplication.class, args);
	}

}
