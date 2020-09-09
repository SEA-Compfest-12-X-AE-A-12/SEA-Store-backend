package com.compfest.sea.repository.proposal;

import com.compfest.sea.entity.proposal.model.Proposal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProposalDAOJPA extends JpaRepository<Proposal, Integer> {
	Proposal save(Proposal proposal);

	Optional<Proposal> findById(Integer integer);

	List<Proposal> findAll();

	Page<Proposal> findAll(Pageable pageable);
}
