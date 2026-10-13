package com.dazayamil.salemanagementapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaleManagementApi {

	public static void main(String[] args) {
		// Carga el .env antes de que Spring arranque
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(SaleManagementApi.class, args);
	}
}
