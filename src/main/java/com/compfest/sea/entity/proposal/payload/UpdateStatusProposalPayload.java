package com.compfest.sea.entity.proposal.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStatusProposalPayload {
  Integer proposalId;
  Boolean approval;
}
