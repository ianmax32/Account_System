package com.naitech.translator.impl;

import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.persistence.Health_fitness;
import com.naitech.repository.persistence.Health_fitness_repo;
import com.naitech.translator.HealthFitnessTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthFitnessTranslatorImpl implements HealthFitnessTranslator {
    private final Health_fitness_repo health_fitness_repo;

    @Autowired
    public HealthFitnessTranslatorImpl(Health_fitness_repo health_fitness_repo) {
        this.health_fitness_repo = health_fitness_repo;
    }

    @Override
    public List<HealthFitnessDto> getHealthFitness() {
        List<HealthFitnessDto> healthFitnessDtos=new ArrayList<>();
        try {
            for(Health_fitness health_fitness: health_fitness_repo.findAll()){
                healthFitnessDtos.add(new HealthFitnessDto(health_fitness));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get info from the db", e);
        }
        return healthFitnessDtos;
    }

    @Override
    public HealthFitnessDto getMemberHealth(Long id) {
        Health_fitness healthFitness = health_fitness_repo.getOne(id);
        return new HealthFitnessDto(healthFitness);
    }
}
