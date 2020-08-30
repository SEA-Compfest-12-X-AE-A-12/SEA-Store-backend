package com.compfest.sea.delivery.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sea/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableAutoConfiguration
public interface ProductDelivery {
    @PostMapping("/insert")
    public List<String> insert(@RequestBody InsertProductPayload insertProductPayload);

    @GetMapping("/ping")
    public String ping();
}
