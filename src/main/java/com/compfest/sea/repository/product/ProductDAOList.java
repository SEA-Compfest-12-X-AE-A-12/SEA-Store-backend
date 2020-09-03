package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Integer update(Product product) throws Exception {
        products.removeIf(p -> p.getMerchantId().equals(product.getMerchantId()) && p.getId().equals(product.getId()));
        products.add(product);
        return 1;
    }

    public List<Product> getAll() throws Exception {
        return products;
    }

    @Override
    public List<Product> getAllByMerchantId(Integer merchantId) throws Exception {
        return products.stream().filter(product -> product.getMerchantId().equals(merchantId)).collect(Collectors.toList());
    }

    @Override
    public Product get(Integer id) throws Exception {
        return products.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
    }

}
