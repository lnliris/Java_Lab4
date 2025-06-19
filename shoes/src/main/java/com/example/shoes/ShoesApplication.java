package com.example.shoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;
import com.example.shoes.entity.Shoe;
import com.example.shoes.repository.ShoeRepository;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import jakarta.persistence.*;

@EntityScan(basePackages = { "com.example.shoes.entity" })
@EnableJpaRepositories(basePackages = { "com.example.shoes.repository" })
@ComponentScan(basePackages = { "com.example.shoes" })
@SpringBootApplication
public class ShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoesApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ShoeRepository shoeRepository) {
		return args -> {
			shoeRepository.saveAll(Arrays.asList(
					new Shoe("4DFWD PULSE SHOES", 160.00, "Adidas",
							"This product is excluded from all promotional discounts and offers", "img1.png"),
					new Shoe("FORUM MID SHOES", 100.00, "Adidas",
							"This product is excluded from all promotional discounts and offers", "img2.png"),
					new Shoe("SUPERNOVA SHOES", 150.00, "Adidas", "NMD City Stock 2", "img3.png"),
					new Shoe("BEACH SEASON SHOES", 160.00, "Adidas", "Summer collection", "img4.png"),
					new Shoe("BLACK THADER", 120.00, "Adidas", "Speed Run", "img5.png"),
					new Shoe("FLOWAIR MID SHOES", 160.00, "Adidas", "Speed Run", "img6.png")));
		};
	}

}
