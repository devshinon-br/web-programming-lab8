package com.example.ufu.vuespring.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private String name;
    private Double price;
    private Date dueDate;
}
