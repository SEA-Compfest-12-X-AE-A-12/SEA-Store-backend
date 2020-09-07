package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.product.ProductDAO;
import com.compfest.sea.repository.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.compfest.sea.entity.product.Adapter.convertInsertPayloadToModel;

@Service("productUsecase1")
public class ProductUsecaseImpl implements ProductUsecase {

  private final ProductDAO productDAO;
  private final UserDAO userDAO;

  @Autowired
  public ProductUsecaseImpl(
    @Qualifier("productRepoDB") ProductDAO productDAO,
    @Qualifier("UserUsecaseImpl") UserDAO userDAO) {
    this.productDAO = productDAO;
    this.userDAO = userDAO;
  }

  @Override
  public List<String> insert(InsertRequestPayload insertRequestPayload) {
    List<String> messages = new ArrayList<>();
    User merchant = null;
    try {
      merchant = validateInsertRequestProduct(messages,insertRequestPayload);
      if (!messages.isEmpty()) {
        if (!Category.isValidCategory(insertRequestPayload.getCategory())) {
          messages.add("Invalid payload of category");
        }
        return messages;
      }
      Product product = convertInsertPayloadToModel(insertRequestPayload, merchant);
      productDAO.save(product);
      messages.add("Success insert new product");
    } catch (Exception e) {
      messages.add("Failed, " + e);
    }
    return messages;
  }

  @Override
  public List<String> update(Product product) {
    List<String> messages = new ArrayList<>(validateProduct(product));
    messages.addAll(verifyOwner(product));
    if (!messages.isEmpty()) {
      return messages;
    }
    try {
      productDAO.update(product);
      messages.add("Success Update Product " + product.getName());
    } catch (Exception e) {
      messages.add("Failed, " + e);
    }
    return messages;
  }

  @Override
  public List<String> delete(Integer id) {
    try {
      if (!productDAO.findById(id).isPresent())
        return Arrays.asList("Failed, product id " + id + " not found");
      productDAO.delete(id);
      return Arrays.asList("Success delete product " + id);
    } catch (Exception e) {
      return Arrays.asList("Failed, Error: " + e);
    }
  }

  @Override
  public List<Product> getAll() {
    try {
      return productDAO.findAll();
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
      return productDAO.findById(id).orElse(null);
    } catch (Exception e) {
      return null;
    }
  }

  public List<String> validateProduct(Product product) {
    List<String> messages = new ArrayList<>();
    if (product == null) {
      return Arrays.asList("Failed, invalid payload");
    }
    if (product.getQuantity() <= 0) {
      messages.add("Failed, Quantity must be more than 0");
    }
    return messages;
  }

  public User validateInsertRequestProduct(List<String> messages, InsertRequestPayload insertRequestPayload) {
    User merchant = userDAO.findUserById(insertRequestPayload.getMerchantId());
    if (merchant == null) {
      messages.add("Failed, Merchant Id " + insertRequestPayload.getMerchantId() + " not found");
    }
    Product product = convertInsertPayloadToModel(insertRequestPayload, merchant);
    messages.addAll(validateProduct(product));
    return merchant;
  }

  public List<String> verifyOwner(Product productUpdate) {
    List<String> messages = new ArrayList<>();
//    try {
//      Product product = productDAO.findById(productUpdate.getId()).orElse(null);
//      if (product == null) {
//        messages.add("Failed, no such product");
//      } else if (productUpdate.getMerchant() == null) {
//        messages.add("Failed, Merchant Id " + produc + " not found");
//      } else if (!(product.getMerchant().getUserID() == productUpdate.getMerchant().getUserID())) {
//        messages.add("Failed, You cannot update someone else's product");
//      }
//    } catch (Exception e) {
//      messages.add("Failed, error: " + e);
//    }
    return messages;
  }

  public List<String> verifyMerchant(Integer merchantId) {
    if (false) { // TODO: waiting for merchant domain
      return Arrays.asList("Failed, Merchant Id " + merchantId + "is not found");
    }
    return new ArrayList<>();
  }
}
