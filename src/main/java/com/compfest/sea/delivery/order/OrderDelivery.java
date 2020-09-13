package com.compfest.sea.delivery.order;

import com.compfest.sea.entity.order.payload.AddToCartRequestPayload;

import java.util.List;

public interface OrderDelivery {
  List<String> addToCart(AddToCartRequestPayload addToCartRequestPayload);
}
