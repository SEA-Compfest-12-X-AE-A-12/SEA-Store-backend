package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.product.Adapter;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.repository.product.ProductDAO;
import com.compfest.sea.repository.product.ProductDAOList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class TestProductUsecase {

  @Mock private final ProductDAO productDAO = mock(ProductDAOList.class);

  @InjectMocks ProductUsecase productUsecase = new ProductUsecaseImpl(productDAO);

  List<Product> mockDB = new ArrayList<>();
  static Product product1 = new Product(0, "p1", "prod1", 1000, 10, 1, Category.SPORT, true);

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void insertValidProduct() {
    InsertRequestPayload validProductPayload =
        new InsertRequestPayload(10, 1, "p1", "prod1", Category.SPORT.toString(), 10000);
    try {
      Product product = Adapter.convertInsertPayloadToModel(validProductPayload);
      when(productDAO.save(product)).thenReturn(product);
      List<String> messages = productUsecase.insert(validProductPayload);
      List<String> expected = Arrays.asList("Success insert new product");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void insertInvalidProduct() {
    InsertRequestPayload invalidProductPayload =
        new InsertRequestPayload(-10, 1, "p1", "prod1", Category.SPORT.toString(), 10000);
    try {
      Product product = Adapter.convertInsertPayloadToModel(invalidProductPayload);
      when(productDAO.save(product)).thenReturn(product);
      List<String> messages = productUsecase.insert(invalidProductPayload);
      List<String> expected = Arrays.asList("Failed, Quantity must be more than 0");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void insertInvalidCategoryProduct() {
    InsertRequestPayload invalidProductPayload =
        new InsertRequestPayload(10, 1, "p1", "prod1", "INVALID", 10000);
    try {
      Product product = Adapter.convertInsertPayloadToModel(invalidProductPayload);
      when(productDAO.save(product)).thenReturn(product);
      List<String> messages = productUsecase.insert(invalidProductPayload);
      List<String> expected =
          Arrays.asList("Failed, invalid payload", "Invalid payload of category");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void updateValidOwnedProduct() {
    try {
      ProductDAO productDAO1 = mock(ProductDAOList.class);
      ProductUsecase productUsecase1 = new ProductUsecaseImpl(productDAO1);
      when(productDAO1.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(product1));
      when(productDAO1.update(any(Product.class))).thenReturn(1);
      List<String> messages = productUsecase1.update(product1);
      List<String> expected = Arrays.asList("Success Update Product " + product1.getName());

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void updateInvalidOwnedProduct() {
    try {
      ProductDAO productDAO1 = mock(ProductDAOList.class);
      ProductUsecase productUsecase1 = new ProductUsecaseImpl(productDAO1);
      when(productDAO1.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(product1));
      when(productDAO1.update(any(Product.class))).thenReturn(1);
      product1.setQuantity(-10);
      List<String> messages = productUsecase1.update(product1);
      product1.setQuantity(10);
      List<String> expected = Arrays.asList("Failed, Quantity must be more than 0");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void updateNonExistedProduct() {
    try {
      ProductDAO productDAO1 = mock(ProductDAOList.class);
      ProductUsecase productUsecase1 = new ProductUsecaseImpl(productDAO1);
      when(productDAO1.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(null));
      when(productDAO1.update(any(Product.class))).thenReturn(1);
      List<String> messages = productUsecase1.update(product1);
      List<String> expected = Arrays.asList("Failed, no such product");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void updateNotOwnedProduct() {
    // TODO: waiting for merchant domain
  }

  @Test
  public void deleteValidProduct() {
    try {
      ProductDAO productDAO1 = mock(ProductDAOList.class);
      ProductUsecase productUsecase1 = new ProductUsecaseImpl(productDAO1);
      when(productDAO1.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(product1));
      when(productDAO1.delete(anyInt())).thenReturn(1);
      List<String> messages = productUsecase1.delete(product1.getId());
      List<String> expected = Arrays.asList("Success delete product " + product1.getId());

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }

  @Test
  public void deleteInvalidProduct() {
    try {
      when(productDAO.findById(anyInt())).thenReturn(null);
      List<String> messages = productUsecase.delete(product1.getId());
      List<String> expected =
          Arrays.asList("Failed, product id " + product1.getId() + " not found");

      assertThat(messages, is(expected));
    } catch (Exception e) {
      fail(String.valueOf(e));
    }
  }
}
