package com.compfest.sea.entity.order.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequestPayload {
  private Integer userId;
  private Integer productId;
  private Integer quantity;
}
