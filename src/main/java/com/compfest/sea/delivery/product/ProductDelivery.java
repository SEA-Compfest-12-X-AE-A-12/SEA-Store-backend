package com.compfest.sea.delivery.product;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.payload.ResponsePayload;
import org.springframework.web.bind.annotation.*;


public interface ProductDelivery {
    public ResponsePayload insert(@RequestBody InsertRequestPayload insertRequestPayload);
    public ResponsePayload update(@RequestBody Product updateRequestPayload);
}
