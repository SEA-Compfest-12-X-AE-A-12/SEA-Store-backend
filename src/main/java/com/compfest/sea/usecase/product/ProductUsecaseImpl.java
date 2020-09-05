package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.repository.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.compfest.sea.usecase.product.Adapter.convertInsertPayloadToModel;

@Service("productUsecase1")
public class ProductUsecaseImpl implements ProductUsecase {

    private final ProductDAO productDAO;

    @Autowired
    public ProductUsecaseImpl(@Qualifier("productRepoDB") ProductDAO productDAO) {
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
            productDAO.save(product);
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
            productDAO.update(product);
            messages.add("Success Update Product "+product.getName());
        }catch (Exception e){
            messages.add("Failed, "+ e);
        }
        return messages;
    }

    @Override
    public List<Product> getAll() {
        try{
            return productDAO.findAll();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public List<Product> getAllByMerchantId(Integer merchantId) {
        try{
            return productDAO.getAllByMerchantId(merchantId);
        }catch(Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public Product get(Integer id) {
        try{
            return productDAO.findById(id).orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    public List<String> validateProduct(Product product){
        List<String> messages = new ArrayList<>();
        if(product.getQuantity() <= 0){
            messages.add("Failed, Quantity must be more than 0");
        }
        return messages;
    }

    public List<String> verifyOwner(Product productUpdate){
        List<String> messages = new ArrayList<>();
        try{
            Product product = productDAO.findById(productUpdate.getId()).orElse(null);
            if(product == null){
                messages.add("Failed, no such product");
            }else if(!product.getMerchantId().equals(productUpdate.getMerchantId())){
                messages.add("Failed, You cannot update someone else's product");
            }
        }catch (Exception e){
            messages.add("Failed, error: "+ e);
        }
        return messages;
    }

}
