package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;

public interface ProductDAO {
    Integer insert(Product product) throws Exception;
    Integer update(Product product) throws Exception;
}
