package com.compfest.sea.delivery.order;

import com.compfest.sea.entity.order.payload.AddToCartRequestPayload;
import com.compfest.sea.usecase.order.OrderUsecase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderDeliveryHttp implements OrderDelivery {
	private final OrderUsecase orderUsecase;

	public OrderDeliveryHttp(@Qualifier("OrderUsecaseImpl") OrderUsecase orderUsecase) {
		this.orderUsecase = orderUsecase;
	}

	@Override
	@PostMapping("/addCart")
	public List<String> addToCart(@RequestBody AddToCartRequestPayload addToCartRequestPayload) {
		return orderUsecase.addToCart(addToCartRequestPayload);
	}
}
