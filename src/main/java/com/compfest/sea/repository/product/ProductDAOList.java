package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productRepoList")
public class ProductDAOList implements ProductDAO{
    static final List<Product> products = new ArrayList<>();

    @Override
    public Integer insert(Product product) throws Exception{
        int currId = products.size();
        product.setId(currId);
        products.add(product);
        return currId;
    }

    @Override
    public List<Product> getAll() throws Exception {
        return products;
    }

    @Override
    public Product get(Integer id) throws Exception {
        return products.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
    }

}
