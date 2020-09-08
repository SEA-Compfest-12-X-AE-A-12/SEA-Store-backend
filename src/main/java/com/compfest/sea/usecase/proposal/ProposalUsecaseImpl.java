package com.compfest.sea.usecase.proposal;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.proposal.Adapter;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;
import com.compfest.sea.repository.merchant.MerchantDAO;
import com.compfest.sea.repository.proposal.ProposalDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProposalUsecaseImpl1")
public class ProposalUsecaseImpl implements ProposalUsecase {

  private final ProposalDAO proposalDAO;
  private final MerchantDAO merchantDAO;

  public ProposalUsecaseImpl(
      ProposalDAO proposalDAO, @Qualifier("MerchantDAOList") MerchantDAO merchantDAO) {
    this.proposalDAO = proposalDAO;
    this.merchantDAO = merchantDAO;
  }

  @Override
  public List<String> insert(InsertProposalPayload insertProposalPayload) {
    List<String> messages = validateProposal(insertProposalPayload);
    if (!messages.isEmpty()) return messages;
    try {
      Merchant merchant = merchantDAO.findByUserId(insertProposalPayload.getMerchantId());
      Proposal proposal = Adapter.convertInsertPayloadToModel(insertProposalPayload, merchant);
      proposalDAO.save(proposal);
    } catch (Exception e) {
      messages.add("Failed, " + e);
    }
    return messages;
  }

  @Override
  public List<Proposal> getAll() {
    return proposalDAO.findAll();
  }

  private List<String> validateProposal(InsertProposalPayload insertProposalPayload) {
    List<String> messages = new ArrayList<>();
    Merchant merchant = merchantDAO.findByUserId(insertProposalPayload.getMerchantId());
    if (merchant == null) {
      messages.add("Failed, invalid author of proposal");
    }
    if (!Category.isValidCategory(insertProposalPayload.getMerchantCategory())) {
      messages.add("Failed, invalid category of proposal");
    }
    return messages;
  }
}
