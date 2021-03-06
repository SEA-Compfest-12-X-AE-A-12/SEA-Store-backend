package com.compfest.sea.delivery.proposal;

import com.compfest.sea.entity.product.payload.ResponsePayload;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;
import com.compfest.sea.entity.proposal.payload.UpdateStatusProposalPayload;

import java.util.List;

public interface ProposalDelivery {
  ResponsePayload insert(InsertProposalPayload insertProposalPayload);

  List<Proposal> getAll();

  List<String> updateStatus(UpdateStatusProposalPayload updateStatusProposalPayload);
}
