package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.repository.product.ProductDAO;
import com.compfest.sea.repository.product.ProductDAOList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestProductUsecase {

    @Mock
    private static ProductDAO productDAO = mock(ProductDAOList.class);
    ProductUsecase productUsecase = new ProductUsecaseImpl(productDAO);
    List<Product> mockDB = new ArrayList<>();
    static Product product1 = new Product(
      0,"p1","prod1", 1000, 10, 1 , Category.SPORT.toString(),true
    );


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insertValidProduct(){
        InsertRequestPayload validProductPayload = new InsertRequestPayload(
          10, 1,"p1", "prod1", Category.SPORT.toString(),10000
        );
        try {
            Product product = Adapter.convertInsertPayloadToModel(validProductPayload);
            Mockito.when(productDAO.insert(product)).thenReturn(1);
            List<String> messages = productUsecase.insert(validProductPayload);
            List<String> expected = Arrays.asList("Success insert new product");

            assertThat(messages, is(expected));
        }catch(Exception e){
            fail(String.valueOf(e));
        }
    }

    @Test
    public void insertInvalidProduct(){
        InsertRequestPayload invalidProductPayload = new InsertRequestPayload(
          -10, 1,"p1", "prod1", Category.SPORT.toString(),10000
        );
        try {
            Product product = Adapter.convertInsertPayloadToModel(invalidProductPayload);
            Mockito.when(productDAO.insert(product)).thenReturn(1);
            List<String> messages = productUsecase.insert(invalidProductPayload);
            List<String> expected = Arrays.asList("Failed, Quantity must be more than 0");

            assertThat(messages, is(expected));
        }catch(Exception e){
            fail(String.valueOf(e));
        }
    }

    @Test
    public void updateValidOwnedProduct(){

    }

    @Test
    public void updateInvalidOwnedProduct(){

    }

    @Test
    public void updateNonExistedProduct(){

    }

    @Test
    public void updateNotOwnedProduct(){

    }
}
