package com.naitech.translator;

import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.domain.DTO.RewardsDto;

import java.util.*;

public interface RewardsTranslator {
    List<RewardsDto> getRewards();
    RewardsDto getReward(Long id);
    void deleteReward(Long id);
    RewardsDto addReward(RewardsDto rewardsDto);
    RewardsDto updateRewardPrice(Long id, RewardsDto rewardsDto);
}
