package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.logic.flow.fetchHealthFitnessFlow;
import com.naitech.translator.HealthFitnessTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchHealthFitnessFlowImpl implements fetchHealthFitnessFlow {
    private final HealthFitnessTranslator healthFitnessTranslator;

    @Autowired
    public FetchHealthFitnessFlowImpl(HealthFitnessTranslator healthFitnessTranslator) {
        this.healthFitnessTranslator = healthFitnessTranslator;
    }

    @Override
    public List<HealthFitnessDto> fetchHealthFitness() {
        List<HealthFitnessDto> healthFitnessDtos = new ArrayList<>();
        healthFitnessDtos = healthFitnessTranslator.getHealthFitness();
        return healthFitnessDtos;
    }

    @Override
    public HealthFitnessDto getMemberHealth(Long id) {
        HealthFitnessDto healthFitnessDto = healthFitnessTranslator.getMemberHealth(id);
        return healthFitnessDto;
    }
}
