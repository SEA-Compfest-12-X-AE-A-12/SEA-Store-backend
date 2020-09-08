package com.compfest.sea.entity.proposal;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.model.ProposalStatus;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;

public class Adapter {
	public static Proposal convertInsertPayloadToModel(InsertProposalPayload insertProposalPayload, Merchant merchant){
		return new Proposal(
			0,
			0,
			merchant,
			insertProposalPayload.getDescription(),
			Category.valueOf(insertProposalPayload.getMerchantCategory()),
			insertProposalPayload.getVision(),
			insertProposalPayload.getMission(),
			insertProposalPayload.getMotivation(),
			ProposalStatus.ON_REVIEW
		);
	}
}
