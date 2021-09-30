package com.naitech.translator.impl;

import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.domain.persistence.RewardsCategories;
import com.naitech.repository.persistence.Rewards_CategoriesRepo;
import com.naitech.translator.RewardsCategoriesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsCategoriesTranslatorImpl implements RewardsCategoriesTranslator {
    private final Rewards_CategoriesRepo rewards_categoriesRepo;

    @Autowired
    public RewardsCategoriesTranslatorImpl(Rewards_CategoriesRepo rewards_categoriesRepo) {
        this.rewards_categoriesRepo = rewards_categoriesRepo;
    }

    @Override
    public List<RewardsCategoriesDto> getRewardsCategories() {
        List<RewardsCategoriesDto> rewardsCategoriesDtos = new ArrayList<>();
        try {
            for(RewardsCategories rewardsCategories: rewards_categoriesRepo.findAll()){
                rewardsCategoriesDtos.add(new RewardsCategoriesDto(rewardsCategories));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get info from the database",e);
        }
        return rewardsCategoriesDtos;
    }
}
