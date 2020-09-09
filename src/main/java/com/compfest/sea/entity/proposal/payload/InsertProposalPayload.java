package com.compfest.sea.entity.proposal.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertProposalPayload {
  private Integer merchantId;
  private String description;
  private String merchantCategory;
  private String vision;
  private String mission;
  private String motivation;
}
