package com.naitech.translator;

import com.naitech.domain.DTO.RewardsCategoriesDto;

import java.util.*;

public interface RewardsCategoriesTranslator {
    List<RewardsCategoriesDto> getRewardsCategories();
    RewardsCategoriesDto addRCategories(RewardsCategoriesDto rewardsCategoriesDto);
    void deleteCategory(String name);
}
