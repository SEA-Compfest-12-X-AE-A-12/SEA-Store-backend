package com.compfest.sea.repository.merchant;

import com.compfest.sea.entity.merchant.model.Withdrawal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("WithdrawalDAOList")
public class WithdrawalDAOList implements WithdrawalDAO {

    private static List<Withdrawal> DB = new ArrayList<>();

    @Override
    public Withdrawal insert(Withdrawal newWithdrawal) {
        DB.add(newWithdrawal);
        return newWithdrawal;
    }
}
