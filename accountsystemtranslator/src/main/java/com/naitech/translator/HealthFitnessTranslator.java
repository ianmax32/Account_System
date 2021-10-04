package com.naitech.translator;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.DTO.MemberDto;

import java.util.*;

public interface HealthFitnessTranslator {
    List<HealthFitnessDto> getHealthFitness();
    HealthFitnessDto getMemberHealth(Long id);
    HealthFitnessDto addMember(MemberDto healthFitnessDto);
    void updateDriving(Long id, HealthFitnessDto healthFitnessDto);
}
