package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("productRepoList")
public class ProductDAOList implements ProductDAO {
  static final List<Product> products = new ArrayList<>();

  @Override
  public Product save(Product product) {
    int currId = products.size();
    product.setId(currId);
    products.add(product);
    return product;
  }

  @Override
  public Integer update(Product product) throws Exception {
    products.removeIf(
        p ->
            p.getMerchantId().equals(product.getMerchantId()) && p.getId().equals(product.getId()));
    products.add(product);
    return 1;
  }

  @Override
  public Integer delete(Integer id) throws Exception {
    products.removeIf(p -> p.getId().equals(id));
    return 1;
  }

  @Override
  public List<Product> getAllByMerchantId(Integer merchantId) throws Exception {
    return products.stream()
        .filter(product -> product.getMerchantId().equals(merchantId))
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Product> findById(Integer id) {
    return products.stream().filter(product -> product.getId().equals(id)).findAny();
  }

  @Override
  public List<Product> findAll() {
    return products;
  }

  @Override
  public Page<Product> findAll(Pageable pageable) {
    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), products.size());
    return new PageImpl<>(products.subList(start, end), pageable, products.size());
  }
}
