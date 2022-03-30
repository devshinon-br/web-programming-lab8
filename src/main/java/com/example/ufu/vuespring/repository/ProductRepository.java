package com.example.ufu.vuespring.repository;

import com.example.ufu.vuespring.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
