package com.productcategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class ProductCategoryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryAppApplication.class, args);
	}

}
