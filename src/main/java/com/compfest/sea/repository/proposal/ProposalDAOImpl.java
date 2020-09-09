package com.compfest.sea.repository.proposal;

import com.compfest.sea.entity.proposal.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ProposalDAODB")
public class ProposalDAOImpl implements ProposalDAO {

	@Autowired @Lazy ProposalDAOJPA proposalDAOJPA;

	@Override
	public Proposal save(Proposal proposal) {
		return proposalDAOJPA.save(proposal);
	}

	@Override
	public Optional<Proposal> findById(Integer integer) {
		return proposalDAOJPA.findById(integer);
	}

	@Override
	public List<Proposal> findAll() {
		return proposalDAOJPA.findAll();
	}

	@Override
	public Page<Proposal> findAll(Pageable pageable) {
		return proposalDAOJPA.findAll(pageable);
	}
}
