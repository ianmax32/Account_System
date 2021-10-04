package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.RewardsCategoriesDto;

public interface FetchRewardsCategoriesFlow {
    List<RewardsCategoriesDto> fetchRewardsCategories();
    RewardsCategoriesDto addRCategories(RewardsCategoriesDto rewardsCategoriesDto);
    void deleteCategory(String name);
}
