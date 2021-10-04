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

    @Override
    public RewardsDto getReward(Long id) {
        RewardsDto rewardsDto = rewardsTranslator.getReward(id);
        return rewardsDto;
    }

    @Override
    public void deleteReward(Long id) {
        rewardsTranslator.deleteReward(id);
    }

    @Override
    public RewardsDto addReward(RewardsDto rewardsDto) {
        RewardsDto rewardsDto1 = rewardsTranslator.addReward(rewardsDto);
        return rewardsDto1;
    }

    @Override
    public RewardsDto updateRewardPrice(Long id, RewardsDto rewardsDto) {
        RewardsDto rewardsDto1 = rewardsTranslator.updateRewardPrice(id,rewardsDto);
        return rewardsDto;
    }
}
