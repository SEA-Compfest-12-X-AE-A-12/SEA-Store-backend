package com.compfest.sea.entity.product.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ResponsePayload {
	@Setter @Getter List<String> messages;

	public ResponsePayload(List<String> messages) {
		this.messages = messages;
	}
}
