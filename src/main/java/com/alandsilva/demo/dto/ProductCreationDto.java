package com.alandsilva.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCreationDto {

    public String title;
    public Double price;
    public int quantity;
    public String brandTitle;
}