package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.RewardsDto;
import com.naitech.logic.flow.FetchRewardsFlow;
import com.naitech.translator.RewardsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchRewardsFlowImpl implements FetchRewardsFlow {
    private final RewardsTranslator rewardsTranslator;

    @Autowired
    public FetchRewardsFlowImpl(RewardsTranslator rewardsTranslator) {
        this.rewardsTranslator = rewardsTranslator;
    }

    @Override
    public List<RewardsDto> fetchRewards() {
        List<RewardsDto> rewardsDtos =new ArrayList<>();
        rewardsDtos = rewardsTranslator.getRewards();
        return rewardsDtos;
    }
}
