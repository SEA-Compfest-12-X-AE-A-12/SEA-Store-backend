package com.compfest.sea.usecase.product;

import com.compfest.sea.entity.product.payload.InsertRequestPayload;
import com.compfest.sea.entity.product.model.Product;

public class Adapter {
	public static Product convertInsertPayloadToModel(InsertRequestPayload insertRequestPayload) throws Exception{
		return new Product(
			0,
			insertRequestPayload.getQuantity(),
			insertRequestPayload.getMerchantId(),
			insertRequestPayload.getCategoryId(),
			insertRequestPayload.getName(),
			insertRequestPayload.getDescription(),
			insertRequestPayload.getPrice()
		);
	}
}
