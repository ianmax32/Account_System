package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.RewardsDto;

public interface FetchRewardsFlow {
    List<RewardsDto> fetchRewards();
    RewardsDto getReward(Long id);
    void deleteReward(Long id);
    RewardsDto addReward(RewardsDto rewardsDto);
    RewardsDto updateRewardPrice(Long id, RewardsDto rewardsDto);
}
