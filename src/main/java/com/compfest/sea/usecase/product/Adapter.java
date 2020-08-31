package com.compfest.sea.usecase.product;

import com.compfest.sea.delivery.product.payload.InsertProductPayload;

public class Adapter {
	public static Product convertInsertPayloadToModel(InsertProductPayload insertProductPayload) throws Exception{
		return new Product(
			0,
			insertProductPayload.getQuantity(),
			insertProductPayload.getMerchantId(),
			insertProductPayload.getCategoryId(),
			insertProductPayload.getName(),
			insertProductPayload.getDescription(),
			insertProductPayload.getPrice()
		);
	}
}
