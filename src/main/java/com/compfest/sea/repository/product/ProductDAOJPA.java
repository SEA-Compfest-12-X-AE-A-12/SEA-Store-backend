package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDAOJPA extends JpaRepository<Product, Integer> {
  Optional<Product> findById(Integer integer);

  List<Product> findAllByActive(Boolean active);

  Page<Product> findAll(Pageable pageable);
}
