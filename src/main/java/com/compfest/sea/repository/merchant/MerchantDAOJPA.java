package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantDAOJPA extends JpaRepository<Merchant, Integer> {}
