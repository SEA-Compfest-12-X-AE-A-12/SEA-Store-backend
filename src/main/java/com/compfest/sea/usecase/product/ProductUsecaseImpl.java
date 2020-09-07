package com.compfest.sea.usecase.product;

import static com.compfest.sea.usecase.product.Adapter.convertInsertPayloadToModel;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.repository.product.ProductDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productUsecase1")
public class ProductUsecaseImpl implements ProductUsecase {

  private final ProductDAO productDAO;

  @Autowired
  public ProductUsecaseImpl(@Qualifier("productRepoList") ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  @Override
  public List<String> insert(InsertRequestPayload insertRequestPayload) {

    List<String> messages = new ArrayList<>();
    messages.addAll(validateProduct(insertRequestPayload));
    if (!messages.isEmpty()) {
      return messages;
    }
    try {
      Product product = convertInsertPayloadToModel(insertRequestPayload);
      productDAO.insert(product);
      messages.add("Success insert new product");
    } catch (Exception e) {
      messages.add(String.valueOf(e));
    }
    return messages;
  }

  @Override
  public List<Product> getAll() {
    try {
      return productDAO.getAll();
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Product> getAllByMerchantId(Integer merchantId) {
    try {
      return productDAO.getAllByMerchantId(merchantId);
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  @Override
  public Product get(Integer id) {
    try {
      return productDAO.get(id);
    } catch (Exception e) {
      return null;
    }
  }

  public List<String> validateProduct(InsertRequestPayload insertRequestPayload) {
    List<String> messages = new ArrayList<>();
    if (insertRequestPayload.getQuantity() <= 0) {
      messages.add("Quantity must be more than 0");
    }
    return messages;
  }
}
