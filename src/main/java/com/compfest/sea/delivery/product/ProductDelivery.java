package com.compfest.sea.delivery.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sea/product")
public interface ProductDelivery {
    @PostMapping("/insert")
    public List<String> insert(@RequestBody InsertProductPayload insertProductPayload);

}
