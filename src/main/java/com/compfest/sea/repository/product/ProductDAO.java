package com.compfest.sea.repository.product;

import com.compfest.sea.usecase.product.Product;

import java.util.List;

public interface ProductDAO {
    Integer insert(Product product) throws Exception;

}
