package com.compfest.sea.usecase.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import com.compfest.sea.repository.product.ProductDAO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.compfest.sea.usecase.product.Adapter.convertInsertPayloadToModel;

@Service("productUsecase1")
public class ProductUsecaseImpl implements ProductUsecase {

    private final ProductDAO productDAO;

    @Autowired
    public ProductUsecaseImpl(@Qualifier("productRepoList") ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<String> insert(InsertProductPayload insertProductPayload) {

        List<String> messages = new ArrayList<>();
        messages.addAll(validateProduct(insertProductPayload));
        if(!messages.isEmpty()){
            return messages;
        }
        try{
            Product product = convertInsertPayloadToModel(insertProductPayload);
            productDAO.insert(product);
            messages.add("Success insert new product");
        }catch (Exception e){
            messages.add(String.valueOf(e));
        }
        return messages;
    }

    public List<String> validateProduct(InsertProductPayload insertProductPayload){
        List<String> messages = new ArrayList<>();
        if(insertProductPayload.getQuantity() <= 0){
            messages.add("Quantity must be more than 0");
        }
        return messages;
    }

}
