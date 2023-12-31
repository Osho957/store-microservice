package com.osho.inventoryservice;

import com.osho.inventoryservice.model.Inventory;
import com.osho.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory product1 = new Inventory();
			product1.setSkuCode("iphone_13");
			product1.setQuantity(100);

			Inventory product2 = new Inventory();
			product2.setSkuCode("iphone_12");
			product2.setQuantity(0);

			inventoryRepository.save(product1);
			inventoryRepository.save(product2);
		};
	}

}
