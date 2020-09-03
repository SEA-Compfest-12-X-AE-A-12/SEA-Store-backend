package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;

import java.util.List;

public interface ProductDAO {
    Integer insert(Product product) throws Exception;
    List<Product> getAll() throws Exception;
    List<Product> getAllByMerchantId(Integer merchantId) throws Exception;
    Product get(Integer id) throws Exception;
}
