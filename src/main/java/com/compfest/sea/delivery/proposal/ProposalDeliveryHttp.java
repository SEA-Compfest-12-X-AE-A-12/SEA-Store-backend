package com.compfest.sea.delivery.proposal;

import com.compfest.sea.entity.product.payload.ResponsePayload;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.proposal.payload.InsertProposalPayload;
import com.compfest.sea.entity.proposal.payload.UpdateStatusProposalPayload;
import com.compfest.sea.usecase.proposal.ProposalUsecase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1/proposals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProposalDeliveryHttp implements ProposalDelivery {
  private final ProposalUsecase proposalUsecase;

  public ProposalDeliveryHttp(@Qualifier("ProposalUsecaseImpl1") ProposalUsecase proposalUsecase) {
    this.proposalUsecase = proposalUsecase;
  }

  @Override
  @PostMapping("/upload")
  public ResponsePayload insert(@RequestBody InsertProposalPayload insertProposalPayload) {
    return new ResponsePayload(proposalUsecase.insert(insertProposalPayload));
  }

  @Override
  @GetMapping("/")
  public List<Proposal> getAll() {
    return proposalUsecase.getAll();
  }

  @Override
  @PutMapping("/updateStatus")
  public List<String> updateStatus(
      @RequestBody UpdateStatusProposalPayload updateStatusProposalPayload) {
    return proposalUsecase.updateStatus(updateStatusProposalPayload);
  }
}
