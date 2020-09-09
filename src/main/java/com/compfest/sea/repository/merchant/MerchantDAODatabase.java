package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository("merchantRepoDB")
public class MerchantDAODatabase implements MerchantDAO {
    @Autowired @Lazy MerchantDAOJPA merchantDAOJPA;

    @Override
    public List<Merchant> findAll() {
        return merchantDAOJPA.findAll();
    }

    @Override
    public Merchant insert(Merchant newMerchant) {
        return merchantDAOJPA.save(newMerchant);
    }

    @Override
    public Merchant findByUserId(int userId) {
        return merchantDAOJPA.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Merchant updateMerchant(int userId, Merchant updatedMerchant) {
        return merchantDAOJPA.save(updatedMerchant);
    }

    @Override
    public void deleteMerchant(int userId) {
    }
}
