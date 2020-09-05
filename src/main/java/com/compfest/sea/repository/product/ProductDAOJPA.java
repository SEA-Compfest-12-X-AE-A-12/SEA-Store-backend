package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductDAOJPA extends JpaRepository<Product, Integer> {
	public Optional<Product> findById(Integer integer);
	public List<Product> findAll();
	public Page<Product> findAll(Pageable pageable);
}
