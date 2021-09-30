package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.HealthFitnessDto;

public interface fetchHealthFitnessFlow {
    List<HealthFitnessDto> fetchHealthFitness();
    HealthFitnessDto getMemberHealth(Long id);
}
