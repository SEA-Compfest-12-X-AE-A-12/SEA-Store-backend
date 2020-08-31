package com.compfest.sea.usecase.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.repository.product.ProductDAO;
import com.compfest.sea.repository.product.ProductDAOList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestProductUsecase {

    @Mock
    private static ProductDAO productDAO = mock(ProductDAOList.class);
    ProductUsecase productUsecase = new ProductUsecaseImpl(productDAO);


    @BeforeClass
    public static void setMockOutput() throws Exception{
        when(productDAO.insert(mock(Product.class))).thenReturn(1);
    }

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insertValidProduct(){
        InsertProductPayload validProductPayload = new InsertProductPayload(
          10, 1, "p1", "prod1", 1, 10000
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
        InsertProductPayload validProductPayload = new InsertProductPayload(
          -10, 1, "p1", "prod1", 1, 10000
        );
        try {
            Product product = Adapter.convertInsertPayloadToModel(validProductPayload);
            Mockito.when(productDAO.insert(product)).thenReturn(1);
            List<String> messages = productUsecase.insert(validProductPayload);
            List<String> expected = Arrays.asList("Quantity must be more than 0");

            assertThat(messages, is(expected));
        }catch(Exception e){
            fail(String.valueOf(e));
        }
    }
}
