package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("fakeDao") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product){
        return productDao.insertProduct(product);
    }

    public List<Product> getAllProduct() {
        return productDao.selectAllProduct();
    }

    public Optional<Product> getProductByID (UUID id) {
        return productDao.selectProductByID(id);
    }

    public int deleteProduct(UUID id){
        return productDao.deleteProductByID(id);
    }

    public int updateProduct(UUID id, Product newProduct){
        return productDao.updateProductByID(id, newProduct);
    }
}
