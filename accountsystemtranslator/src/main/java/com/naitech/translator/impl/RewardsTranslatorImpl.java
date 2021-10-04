package com.naitech.translator.impl;

import com.naitech.domain.DTO.RewardsDto;
import com.naitech.domain.persistence.Rewards;
import com.naitech.domain.persistence.RewardsCategories;
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
    private final Rewards_CategoriesRepo rewards_categoriesRepo;

    @Autowired
    public RewardsTranslatorImpl(RewardsRepo rewardsRepo, Rewards_CategoriesRepo rewards_categoriesRepo) {
        this.rewardsRepo = rewardsRepo;
        this.rewards_categoriesRepo = rewards_categoriesRepo;
    }




    @Override
    public List<RewardsDto> getRewards() {
        List<RewardsDto> rewardsDtos = new ArrayList<>();
        try {
            for(Rewards rewards: rewardsRepo.findAll()){
                rewardsDtos.add(new RewardsDto(rewards));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get rewards from db",e);
        }
        return rewardsDtos;
    }

    @Override
    public RewardsDto getReward(Long id) {
        Rewards rewards;
        try {
            rewards = rewardsRepo.getOne(id);

        }catch(Exception e){
            throw new RuntimeException("Cannot get reward from db",e);
        }
        return new RewardsDto(rewards);
    }

    @Override
    public void deleteReward(Long id) {
        try {
            rewardsRepo.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Cannot delete reward from db",e);
        }
    }

    @Override
    public RewardsDto addReward(RewardsDto rewardsDto) {
        Rewards rewards;
        try {
            RewardsCategories rewardsCategories = rewards_categoriesRepo.getRewardsCategoryUniqueName(rewardsDto.getReward_category_name().getCategory_Name());
            rewards = rewardsDto.buildReward(rewardsCategories);
            rewardsRepo.save(rewards);
        }catch(Exception e){
            throw new RuntimeException("Cannot add a new reward into db",e);
        }
        return rewardsDto;
    }

    @Override
    public RewardsDto updateRewardPrice(Long id, RewardsDto rewardsDto) {
        try {
            double amount = rewardsDto.getReward_amount();
            rewardsRepo.updateRewardPrices(id,amount);
        }catch(Exception e){
            throw new RuntimeException("Cannot update the reward price db",e);
        }
        return rewardsDto;
    }
}
