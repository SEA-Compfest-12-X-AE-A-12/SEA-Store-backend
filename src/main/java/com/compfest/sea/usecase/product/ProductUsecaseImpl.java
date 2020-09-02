package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.repository.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.compfest.sea.usecase.product.Adapter.convertInsertPayloadToModel;

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
        try{
            Product product = convertInsertPayloadToModel(insertRequestPayload);
            messages.addAll(validateProduct(product));
            if(!messages.isEmpty()){
                return messages;
            }
            productDAO.insert(product);
            messages.add("Success insert new product");
        }catch (Exception e){
            messages.add("Failed, "+ e);
        }
        return messages;
    }

    @Override
    public List<String> update(Product product) {
        List<String> messages = new ArrayList<>(validateProduct(product));
        messages.addAll(verifyOwner(product));
        if(!messages.isEmpty()){
            return messages;
        }
        try{
            productDAO.insert(product);
            messages.add("Success Update Product "+product.getName());
        }catch (Exception e){
            messages.add("Failed, "+ e);
        }
        return messages;
    }

    public List<String> validateProduct(Product product){
        List<String> messages = new ArrayList<>();
        if(product.getQuantity() <= 0){
            messages.add("Failed, Quantity must be more than 0");
        }
        return messages;
    }

    public List<String> verifyOwner(Product productUpdate){
        Product product = new Product(); // todo: waiting for merged PR of get product by id
        List<String> messages = new ArrayList<>();
        if(!product.getMerchantId().equals(productUpdate.getMerchantId())){
            messages.add("Failed, You cannot update someone else's product");
        }
        return messages;
    }

}
