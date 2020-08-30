package com.compfest.sea.usecase.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.repository.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productUsecase1")
public class ProductUseCaseImpl implements ProductUsecase {

    private final ProductDAO productDAO;

    @Autowired
    public ProductUseCaseImpl(@Qualifier("productRepoList") ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<String> insert(InsertProductPayload insertProductPayload) {
        Product product = new Product(
                0,
                insertProductPayload.getQuantity(),
                insertProductPayload.getMerchantId(),
                insertProductPayload.getName(),
                insertProductPayload.getDescription(),
                insertProductPayload.getCategory(),
                insertProductPayload.getPrice()
        );
        return productDAO.insert(product);
    }
}
