package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchAccountTypeFlow;
import com.naitech.logic.flow.FetchDrivingFlow;
import com.naitech.translator.DrivingTranslator;
import com.naitech.translator.MembersTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchDrivingFlowImpl implements FetchDrivingFlow {
    private final DrivingTranslator drivingTranslator;
    private final MembersTranslator membersTranslator;

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchDrivingFlowImpl.class);

    public FetchDrivingFlowImpl(DrivingTranslator drivingTranslator, MembersTranslator membersTranslator) {
        this.drivingTranslator = drivingTranslator;
        this.membersTranslator = membersTranslator;
    }

    @Autowired


    @Override
    public List<DrivingDto> fetchDriving() {
        List<DrivingDto> drivingDtos = new ArrayList<>();
        drivingDtos = drivingTranslator.getDriving();
        LOGGER.info("Fetched driving dtos for all members: {} ",drivingDtos);
        return drivingDtos;
    }

    @Override
    public DrivingDto fetchMemberDriving(Long id) {
        DrivingDto drivingDto = drivingTranslator.getMemberDriving(id);
        LOGGER.info("Fetched driving dtos for the member with id {} is : {} ",drivingDto);
        return drivingDto;
    }

    @Override
    public DrivingDto addMember(MemberDto drivingDto) {
        drivingTranslator.addDriving(drivingDto);
        LOGGER.info("Member entry into the driving entity : {} ",drivingDto);
        return drivingDto.getDrivingDto();
    }

    @Override
    public void updateDriving(Long id, DrivingDto drivingDto) {
        drivingTranslator.updateDriving(id,drivingDto);
    }
}
