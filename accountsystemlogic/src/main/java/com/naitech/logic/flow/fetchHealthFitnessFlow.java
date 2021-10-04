package com.naitech.logic.flow;

import java.util.*;
import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.DTO.MemberDto;

public interface fetchHealthFitnessFlow {
    void addMember(MemberDto healthFitnessDto);
    List<HealthFitnessDto> fetchHealthFitness();
    HealthFitnessDto getMemberHealth(Long id);
    void updateDriving(Long id, HealthFitnessDto healthFitnessDto);
}
