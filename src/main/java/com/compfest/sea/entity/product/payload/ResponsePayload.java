package com.compfest.sea.entity.product.payload;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class ResponsePayload {
  @Setter @Getter List<String> messages;

  public ResponsePayload(List<String> messages) {
    this.messages = messages;
  }
}
