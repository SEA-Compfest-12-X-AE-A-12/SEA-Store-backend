package com.compfest.sea.repository.product;

import com.compfest.sea.usecase.product.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productRepoList")
public class ProductListDAO implements ProductDAO{
    List<Product> products = new ArrayList<>();

    @Override
    public List<String> insert(Product product) {
        List<String> messages = new ArrayList<>();
        try{
            product.setId(products.size());
            products.add(product);
            messages.add("Success add new product");
        }catch (Exception e ){
            messages.add(String.valueOf(e));
        }
        return messages;
    }
}
