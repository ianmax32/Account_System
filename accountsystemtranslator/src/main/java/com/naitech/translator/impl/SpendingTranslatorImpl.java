package com.naitech.translator.impl;

import com.naitech.domain.DTO.SpendingDto;
import com.naitech.domain.persistence.Spending;
import com.naitech.repository.persistence.SpendingRepo;
import com.naitech.translator.SpendingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpendingTranslatorImpl implements SpendingTranslator {
    private final SpendingRepo spendingRepo;

    @Autowired
    public SpendingTranslatorImpl(SpendingRepo spendingRepo) {
        this.spendingRepo = spendingRepo;
    }

    @Override
    public List<SpendingDto> getSpending() {
        List<SpendingDto> spendingDtos = new ArrayList<>();
        try {
            for(Spending spending: spendingRepo.findAll()){
                spendingDtos.add(new SpendingDto(spending));
            }
        }catch(Exception e){
            throw new RuntimeException("cannot get info forom db",e);
        }
        return spendingDtos;
    }

    @Override
    public SpendingDto getMemberSpending(Long id) {
        Spending spending = spendingRepo.getOne(id);
        return new SpendingDto(spending);
    }
}
