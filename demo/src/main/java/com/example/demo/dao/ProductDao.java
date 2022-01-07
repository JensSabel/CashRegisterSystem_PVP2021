package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

    int insertProduct(UUID id, Product product);

    default int insertProduct(Product product){
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }

    List<Product> selectAllProduct();

    Optional<Product> selectProductByID(UUID id);

    int deleteProductByID (UUID id);
    int updateProductByID (UUID id, Product product);
}
