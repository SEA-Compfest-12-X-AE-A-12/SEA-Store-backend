package com.compfest.sea.repository.product;

import com.compfest.sea.usecase.product.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productRepoList")
public class ProductDAOList implements ProductDAO{
    List<Product> products = new ArrayList<>();

    @Override
    public Integer insert(Product product) throws Exception{
        int currId = products.size();
        product.setId(currId);
        products.add(product);
        return currId;
    }
}
