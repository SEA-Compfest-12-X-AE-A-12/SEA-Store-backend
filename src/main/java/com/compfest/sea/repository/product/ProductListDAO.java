package com.compfest.sea.repository.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.usecase.product.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProductListDAO implements ProductDAO{
    List<Product> products;

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
