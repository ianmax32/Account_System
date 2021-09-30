package com.naitech.translator.impl;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.persistence.Driving;
import com.naitech.repository.persistence.DrivingRepo;
import com.naitech.translator.DrivingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrivingTranslatorImpl implements DrivingTranslator {
    private final DrivingRepo drivingRepo;

    @Autowired
    public DrivingTranslatorImpl(DrivingRepo drivingRepo) {
        this.drivingRepo = drivingRepo;
    }

    @Override
    public List<DrivingDto> getDriving() {
        List<DrivingDto> drivingDtos = new ArrayList<>();
        try {
            for(Driving driving:drivingRepo.findAll()){
                drivingDtos.add(new DrivingDto(driving));
            }
        }catch(Exception e){
            throw  new RuntimeException("Cannot get info from the db",e);
        }
        return drivingDtos;
    }

    @Override
    public DrivingDto getMemberDriving(Long id) {
        Driving driver = drivingRepo.getOne(id);
        return new DrivingDto(driver);
    }
}
