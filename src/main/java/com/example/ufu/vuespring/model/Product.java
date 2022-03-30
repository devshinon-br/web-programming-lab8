package com.example.ufu.vuespring.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z-'`]+[ a-zA-Z-'`]")
    private String name;

    @NotNull
    @DecimalMin(value = "0.0")
    private Double price;

    @NotNull
    private Date dueDate;
}
