package com.naitech.translator.impl;

import com.naitech.domain.DTO.RewardsDto;
import com.naitech.domain.persistence.Rewards;
import com.naitech.domain.persistence.RewardsCategories;
import com.naitech.repository.persistence.RewardsRepo;
import com.naitech.repository.persistence.Rewards_CategoriesRepo;
import com.naitech.translator.RewardsTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardsTranslatorImpl implements RewardsTranslator {
    private final RewardsRepo rewardsRepo;
    private final Rewards_CategoriesRepo rewards_categoriesRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(RewardsTranslatorImpl.class);


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
            LOGGER.info("All the rewards added in the databse are {}",rewardsDtos);
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
            LOGGER.info("Reward with the id {} is {}",id, rewards);
        }catch(Exception e){
            throw new RuntimeException("Cannot get reward from db",e);
        }
        return new RewardsDto(rewards);
    }

    @Override
    public void deleteReward(Long id) {
        try {
            rewardsRepo.deleteById(id);
            LOGGER.info("Deleting reward with id {}",id);
        }catch(Exception e){
            throw new RuntimeException("Cannot delete reward from db",e);
        }
    }

    @Override
    public RewardsDto addReward(RewardsDto rewardsDto) {
        Rewards rewards;
        LOGGER.info("Getting reward category type based on the name : {}",rewardsDto.getReward_category_name().getCategory_Type());
        try {
            RewardsCategories rewardsCategories = rewards_categoriesRepo.getRewardsCategoryUniqueName(rewardsDto.getReward_category_name().getCategory_Type());
            LOGGER.info("Reward category based on the unique name {}",rewardsCategories);
            rewards = rewardsDto.buildReward(rewardsCategories);
            LOGGER.info("Reward that has been build from reward category {}",rewardsCategories);
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
            LOGGER.info("Updating rewards of id {} with amount {}", id, amount);
            rewardsRepo.updateRewardPrices(id,amount);
        }catch(Exception e){
            throw new RuntimeException("Cannot update the reward price db",e);
        }
        return rewardsDto;
    }
}
