package com.naitech.translator.impl;

import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.domain.persistence.RewardsCategories;
import com.naitech.repository.persistence.Rewards_CategoriesRepo;
import com.naitech.translator.RewardsCategoriesTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsCategoriesTranslatorImpl implements RewardsCategoriesTranslator {
    private final Rewards_CategoriesRepo rewards_categoriesRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(RewardsCategoriesTranslatorImpl.class);


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
            LOGGER.info("Rewards categories available: {}",rewardsCategoriesDtos);
        }catch(Exception e){
            throw new RuntimeException("Cannot get info from the database",e);
        }
        return rewardsCategoriesDtos;
    }

    @Override
    public RewardsCategoriesDto addRCategories(RewardsCategoriesDto rewardsCategoriesDto) {
        RewardsCategories rewardsCategories = new RewardsCategories();
        try {
            rewardsCategories.setCategory_id(null);
            rewardsCategories.setCategory_Name(rewardsCategoriesDto.getCategory_Name());
            rewardsCategories.setCategory_Type(rewardsCategoriesDto.getCategory_Type());

            LOGGER.info("Rewards categories to be saved: {}",rewardsCategories);
            rewards_categoriesRepo.save(rewardsCategories);
        }catch(Exception e){
            throw new RuntimeException("Cannot save category from the database",e);
        }
        return rewardsCategoriesDto;
    }

    @Override
    public void deleteCategory(String name) {
        try {
            RewardsCategories rewardsCategories = rewards_categoriesRepo.getRewardsCategoryUniqueName(name);
            rewards_categoriesRepo.delete(rewardsCategories);
            LOGGER.info("Delete Rewards categories by name: {}",name);
        }catch(Exception e){
            throw new RuntimeException("Cannot delete category from the database",e);
        }
    }
}
