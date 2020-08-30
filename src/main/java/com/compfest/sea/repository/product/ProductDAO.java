package com.compfest.sea.repository.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.usecase.product.Product;

import java.util.List;

public interface ProductDAO {
    List<String> insert(Product product);

}
