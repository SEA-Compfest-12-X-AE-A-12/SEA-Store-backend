package com.compfest.sea.usecase.proposal;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.proposal.Adapter;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.model.ProposalStatus;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;
import com.compfest.sea.entity.proposal.payload.UpdateStatusProposalPayload;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.merchant.MerchantDAO;
import com.compfest.sea.repository.proposal.ProposalDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("ProposalUsecaseImpl1")
public class ProposalUsecaseImpl implements ProposalUsecase {

  private final Logger logger = LoggerFactory.getLogger(ProposalUsecaseImpl.class);
  private final ProposalDAO proposalDAO;
  private final MerchantDAO merchantDAO;

  @Autowired
  public ProposalUsecaseImpl(@Qualifier("ProposalDAODB") ProposalDAO proposalDAO, @Qualifier("MerchantDAOList") MerchantDAO merchantDAO) {
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
      return Arrays.asList("Success upload proposal");
    } catch (Exception e) {
      messages.add("Failed, " + e);
    }
    return messages;
  }

  @Override
  public List<Proposal> getAll() {
    return proposalDAO.findAll();
  }

  @Override
  @Transactional
  public List<String> updateStatus(UpdateStatusProposalPayload updateStatusProposalPayload) {
    Proposal proposal =
        proposalDAO.findById(updateStatusProposalPayload.getProposalId()).orElse(null);
    List<String> messages = validateUpdateStatusProposal(updateStatusProposalPayload, proposal);
    if (!messages.isEmpty()) return messages;

    try {
      proposal.setProposalStatus(
          updateStatusProposalPayload.getApproval()
              ? ProposalStatus.ACCEPTED
              : ProposalStatus.REJECTED);
      if (updateStatusProposalPayload.getApproval()) {
        Merchant merchant = proposal.getMerchant();
        if (merchant == null) {
          messages.add("Failed, no merchant with status updated proposal");
          return messages;
        }
        merchant.setVerified(true);
        // merchantDAO.save(merchant); //TODO: waiting for merchant JPA
      }
      User reviewer =
          ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
      proposal.setReviewedByAdminId(reviewer.getId());
      logger.info(proposal.getId() + proposal.getDescription());
      proposalDAO.save(proposal);
      return Arrays.asList(
          "Success, update status "
              + proposal.getId()
              + " to "
              + (updateStatusProposalPayload.getApproval()
                  ? ProposalStatus.ACCEPTED
                  : ProposalStatus.REJECTED));

    } catch (Exception e) {
      logger.error(e + "");
      return Arrays.asList("Failed, " + e);
    }
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

  private List<String> validateUpdateStatusProposal(
      UpdateStatusProposalPayload updateStatusProposalPayload, Proposal proposal) {
    List<String> messages = new ArrayList<>();
    if (proposal == null) {
      messages.add("Proposal " + updateStatusProposalPayload.getProposalId() + " not found");
    } else if (proposal.getProposalStatus() != ProposalStatus.ON_REVIEW) {
      messages.add(
          "Proposal "
              + updateStatusProposalPayload.getProposalId()
              + " has been "
              + proposal.getProposalStatus());
    }
    return messages;
  }
}
