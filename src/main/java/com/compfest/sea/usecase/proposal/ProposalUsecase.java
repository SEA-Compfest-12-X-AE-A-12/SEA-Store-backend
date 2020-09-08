package com.compfest.sea.usecase.proposal;

import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;

import java.util.List;

public interface ProposalUsecase {
  List<String> insert(InsertProposalPayload insertProposalPayload);
  List<Proposal> getAll();
}
