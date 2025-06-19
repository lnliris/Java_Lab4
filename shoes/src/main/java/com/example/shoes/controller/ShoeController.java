package com.example.shoes.controller;

import com.example.shoes.entity.Shoe;
import com.example.shoes.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

class ShoeDTO {
    private Long id;
    private String name;
    private Double price;
    private String brand;
    private String description;
    private String imageUrl;

    public ShoeDTO(Long id, String name, Double price, String brand, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

@CrossOrigin
@RestController
@RequestMapping("/api/shoes")
public class ShoeController {
    @Autowired
    private ShoeService shoeService;

    @GetMapping
    public List<ShoeDTO> getAllShoes() {
        return shoeService.getAllShoes().stream()
                .map(shoe -> new ShoeDTO(
                        shoe.getId(),
                        shoe.getName(),
                        shoe.getPrice(),
                        shoe.getBrand(),
                        shoe.getDescription(),
                        shoe.getImageUrl()))
                .toList();
    }
}