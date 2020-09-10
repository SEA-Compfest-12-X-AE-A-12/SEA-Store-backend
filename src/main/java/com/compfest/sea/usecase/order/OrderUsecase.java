package com.compfest.sea.usecase.order;

import com.compfest.sea.entity.order.payload.AddToCartRequestPayload;

import java.util.List;

public interface OrderUsecase {
	List<String> addToCart(AddToCartRequestPayload addToCartRequestPayload);
}
