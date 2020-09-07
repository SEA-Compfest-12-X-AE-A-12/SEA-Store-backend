package com.compfest.sea.repository.product;

import com.compfest.sea.entity.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository("productRepoDB")
public class ProductDAODatabase implements ProductDAO {

  @Autowired @Lazy ProductDAOJPA productDAOJPA;
  @Autowired @Lazy ProductDAOJPACustom productDAOJPACustom;

  @Override
  public Product save(Product product) {
    return productDAOJPA.save(product);
  }

  @Override
  public Optional<Product> findById(Integer id) {
    return productDAOJPA.findById(id);
  }

  @Override
  public List<Product> findAll() {
    return productDAOJPA.findAll();
  }

  @Override
  public Page<Product> findAll(Pageable pageable) {
    return productDAOJPA.findAll(pageable);
  }

  @Override
  public Integer update(Product product) throws Exception {
    Product currProduct = findById(product.getId()).orElse(null);
    if (currProduct == null) throw new EntityNotFoundException();
    currProduct = product;
    save(currProduct); // save will check if exists then update, else create new product
    return 1;
  }

  @Override
  public Integer delete(Integer id) throws Exception {
    Product currProduct = findById(id).orElse(null);
    if (currProduct == null) throw new EntityNotFoundException();
    currProduct.setActive(false);
    save(currProduct); // save will check if exists then update, else create new product
    return 1;
  }

  @Override
  public List<Product> getAllByMerchantId(Integer merchantId) throws Exception {
      return productDAOJPACustom.findAllByMerchantId(merchantId);
  }
}
