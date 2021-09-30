package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.RewardsDto;

public interface FetchRewardsFlow {
    List<RewardsDto> fetchRewards();
}
