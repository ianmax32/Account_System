package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.domain.DTO.DrivingDto;
import com.naitech.logic.flow.FetchAccountTypeFlow;
import com.naitech.logic.flow.FetchDrivingFlow;
import com.naitech.translator.DrivingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchDrivingFlowImpl implements FetchDrivingFlow {
    private final DrivingTranslator drivingTranslator;

    @Autowired
    public FetchDrivingFlowImpl(DrivingTranslator drivingTranslator) {
        this.drivingTranslator = drivingTranslator;
    }

    @Override
    public List<DrivingDto> fetchDriving() {
        List<DrivingDto> drivingDtos = new ArrayList<>();
        drivingDtos = drivingTranslator.getDriving();
        return drivingDtos;
    }

    @Override
    public DrivingDto fetchMemberDriving(Long id) {
        DrivingDto drivingDto = drivingTranslator.getMemberDriving(id);
        return drivingDto;
    }
}
