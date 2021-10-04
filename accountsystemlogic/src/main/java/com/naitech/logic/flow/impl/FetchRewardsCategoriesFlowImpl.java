package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.logic.flow.FetchRewardsCategoriesFlow;
import com.naitech.translator.RewardsCategoriesTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchRewardsCategoriesFlowImpl implements FetchRewardsCategoriesFlow {
    private final RewardsCategoriesTranslator rewardsCategoriesTranslator;

    @Autowired
    public FetchRewardsCategoriesFlowImpl(RewardsCategoriesTranslator rewardsCategoriesTranslator) {
        this.rewardsCategoriesTranslator = rewardsCategoriesTranslator;
    }

    @Override
    public List<RewardsCategoriesDto> fetchRewardsCategories() {
        List<RewardsCategoriesDto> rewardsCategoriesDtos = new ArrayList<>();
        rewardsCategoriesDtos = rewardsCategoriesTranslator.getRewardsCategories();
        return rewardsCategoriesDtos;
    }

    @Override
    public RewardsCategoriesDto addRCategories(RewardsCategoriesDto rewardsCategoriesDto) {
        return rewardsCategoriesTranslator.addRCategories(rewardsCategoriesDto);
    }

    @Override
    public void deleteCategory(String name) {
        rewardsCategoriesTranslator.deleteCategory(name);
    }
}
