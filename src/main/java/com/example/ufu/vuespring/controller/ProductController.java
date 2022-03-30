package com.example.ufu.vuespring.controller;

import com.example.ufu.vuespring.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import com.example.ufu.vuespring.model.Product;
import com.example.ufu.vuespring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ResponseBody
    @PostMapping(consumes = {"application/json"})
    public String save (@RequestBody ProductDTO productDTO) {
        try {
            if(Objects.isNull(productDTO)){
                return "Unable to save a null product";
            }

            Product p = new Product();
            p.setPrice(productDTO.getPrice());
            p.setName(productDTO.getName());
            p.setDueDate(productDTO.getDueDate());
            productRepository.save(p);
        }
        catch (Exception e){
            log.error("Error Saving Product {}", productDTO);
            return "Error Saving Product";
        }
        return "Product Saved";
    }

    @GetMapping("/{id}")
    public @ResponseBody Product getProduct(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping
    public @ResponseBody Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
