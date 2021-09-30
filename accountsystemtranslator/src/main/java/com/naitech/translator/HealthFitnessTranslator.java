package com.naitech.translator;

import com.naitech.domain.DTO.HealthFitnessDto;

import java.util.*;

public interface HealthFitnessTranslator {
    List<HealthFitnessDto> getHealthFitness();
    HealthFitnessDto getMemberHealth(Long id);
}
