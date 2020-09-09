package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalDAOJPA extends JpaRepository<Withdrawal, Integer> {}
