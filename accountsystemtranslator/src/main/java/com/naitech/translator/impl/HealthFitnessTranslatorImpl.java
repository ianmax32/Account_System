package com.naitech.translator.impl;

import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Health_fitness;
import com.naitech.domain.persistence.Member;
import com.naitech.repository.persistence.Health_fitness_repo;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.translator.HealthFitnessTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthFitnessTranslatorImpl implements HealthFitnessTranslator {
    private final Health_fitness_repo health_fitness_repo;
    private final MemberRepo memberRepo;

    public HealthFitnessTranslatorImpl(Health_fitness_repo health_fitness_repo, MemberRepo memberRepo) {
        this.health_fitness_repo = health_fitness_repo;
        this.memberRepo = memberRepo;
    }

    @Autowired


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

    @Override
    public HealthFitnessDto addMember(MemberDto memberDto) {
        Health_fitness health_fitness;
        HealthFitnessDto healthFitnessDto = memberDto.getHealthFitnessDto();
        try {
            Member member = memberRepo.getID(memberDto.getName(), memberDto.getSurname());
            health_fitness = healthFitnessDto.buildHealth(member);

            health_fitness_repo.save(health_fitness);
        }catch(Exception e){
            throw new RuntimeException("Cannot add hf into the db", e);
        }
        return healthFitnessDto;
    }

    @Override
    public void updateDriving(Long id, HealthFitnessDto healthFitnessDto) {
        Health_fitness health_fitness;
        try {
            Member member = memberRepo.getOne(id);
            health_fitness = healthFitnessDto.buildHealth(member);
            health_fitness_repo.updateByMemberId(member.getIdNUmber(),healthFitnessDto.getCurrent_amount());
        }catch(Exception e){
            throw  new RuntimeException("Cannot update member health_fitness to the db",e);
        }
    }
}
