package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.SpendingDto;

public interface FetchSpendingFlow {
    List<SpendingDto> fetchSpending();
    SpendingDto getMemberSpending(Long id);
}
