package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.data.repository.Repository;


public interface ProductDAOJPACustom extends Repository<Product, Integer> {
  //  @Query("SELECT p FROM Product p where p.merchant_id  = :merchantId")
  //  List<Product> findAllByMerchantId(@Param("merchantId") Integer merchantId);
}
