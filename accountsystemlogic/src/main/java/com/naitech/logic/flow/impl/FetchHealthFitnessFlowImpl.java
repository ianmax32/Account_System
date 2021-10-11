package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.logic.flow.fetchHealthFitnessFlow;
import com.naitech.translator.HealthFitnessTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchHealthFitnessFlowImpl implements fetchHealthFitnessFlow {
    private final HealthFitnessTranslator healthFitnessTranslator;

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchHealthFitnessFlowImpl.class);

    @Autowired
    public FetchHealthFitnessFlowImpl(HealthFitnessTranslator healthFitnessTranslator) {
        this.healthFitnessTranslator = healthFitnessTranslator;
    }

    @Override
    public List<HealthFitnessDto> fetchHealthFitness() {
        List<HealthFitnessDto> healthFitnessDtos = new ArrayList<>();
        healthFitnessDtos = healthFitnessTranslator.getHealthFitness();
        LOGGER.info("Fetched values for health and fitness are: {}", healthFitnessDtos);
        return healthFitnessDtos;
    }

    @Override
    public HealthFitnessDto getMemberHealth(Long id) {
        HealthFitnessDto healthFitnessDto = healthFitnessTranslator.getMemberHealth(id);
        LOGGER.info("Fetched values for health and fitness where member is {}: is {}",id, healthFitnessDto);
        return healthFitnessDto;
    }

    @Override
    public void addMember(MemberDto healthFitnessDto) {
        LOGGER.info("Member entry to be deleted from the entity is {}", healthFitnessDto);
        healthFitnessTranslator.addMember(healthFitnessDto);
    }

    @Override
    public void updateDriving(Long id, HealthFitnessDto healthFitnessDto) {
        LOGGER.info("Member with is {} is updated with  {}",id, healthFitnessDto);
        healthFitnessTranslator.updateDriving(id,healthFitnessDto);
    }
}
