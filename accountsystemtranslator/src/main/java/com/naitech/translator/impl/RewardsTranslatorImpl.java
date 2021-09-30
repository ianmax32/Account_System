package com.naitech.translator.impl;

import com.naitech.domain.DTO.RewardsDto;
import com.naitech.domain.persistence.Rewards;
import com.naitech.repository.persistence.RewardsRepo;
import com.naitech.repository.persistence.Rewards_CategoriesRepo;
import com.naitech.translator.RewardsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsTranslatorImpl implements RewardsTranslator {
    private final RewardsRepo rewardsRepo;

    @Autowired
    public RewardsTranslatorImpl(RewardsRepo rewardsRepo) {
        this.rewardsRepo = rewardsRepo;
    }

    @Override
    public List<RewardsDto> getRewards() {
        List<RewardsDto> rewardsDtos = new ArrayList<>();
        try {
            for(Rewards rewards: rewardsRepo.findAll()){
                rewardsDtos.add(new RewardsDto(rewards));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get info from db",e);
        }
        return rewardsDtos;
    }
}
