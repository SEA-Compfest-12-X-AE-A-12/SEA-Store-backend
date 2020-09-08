package com.compfest.sea.delivery.proposal;

import com.compfest.sea.entity.product.payload.ResponsePayload;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;

public interface ProposalDelivery {
  ResponsePayload insert(InsertProposalPayload insertProposalPayload);
}
