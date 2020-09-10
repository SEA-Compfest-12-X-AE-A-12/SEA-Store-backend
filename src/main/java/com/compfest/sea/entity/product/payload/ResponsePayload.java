package com.compfest.sea.entity.product.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponsePayload {
  List<String> messages;
}
