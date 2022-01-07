package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import javax.websocket.OnClose;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeProductDataAcessService implements ProductDao {

    private static List<Product> DB = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        DB.add(new Product(id, product.getName(), product.getprice()));
        return 1;
    }

    @Override
    public List<Product> selectAllProduct() {
        return DB;
    }

    @Override
    public Optional<Product> selectProductByID(UUID id) {
        return DB.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteProductByID(UUID id) {
        Optional<Product> productMaybe = selectProductByID(id);
        if(!productMaybe.isPresent()) {
            return 0;
        }
        DB.remove(productMaybe.get());
        return 1;
    }

    @Override
    public int updateProductByID(UUID id, Product newProduct) {
        return selectProductByID(id)
                .map(product -> {
                    int indexOfProductToUpdate = DB.indexOf(product);
                    if (indexOfProductToUpdate >= 0){
                        DB.set(indexOfProductToUpdate, new Product(id, newProduct.getName(), newProduct.getprice()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
