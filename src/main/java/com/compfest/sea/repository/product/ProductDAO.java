package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Product save(Product product);
    public Optional<Product> findById(Integer integer);
    public List<Product> findAll();
    public Page<Product> findAll(Pageable pageable);
    Integer update(Product product) throws Exception;
    Integer delete(Integer id) throws Exception;
    List<Product> getAllByMerchantId(Integer merchantId) throws Exception;
}
