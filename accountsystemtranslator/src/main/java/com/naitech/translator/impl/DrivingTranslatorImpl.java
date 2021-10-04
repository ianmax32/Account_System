package com.naitech.translator.impl;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Member;
import com.naitech.repository.persistence.DrivingRepo;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.translator.DrivingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrivingTranslatorImpl implements DrivingTranslator {
    private final DrivingRepo drivingRepo;
    private final MemberRepo memberRepo;

    public DrivingTranslatorImpl(DrivingRepo drivingRepo, MemberRepo memberRepo) {
        this.drivingRepo = drivingRepo;
        this.memberRepo = memberRepo;
    }

    @Autowired


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

    @Override
    public DrivingDto addDriving(MemberDto memberDto) {
        Driving driving;
        DrivingDto drivingDto = memberDto.getDrivingDto();
        try {
            Member member = memberRepo.getID(memberDto.getName(), memberDto.getSurname());
            driving = drivingDto.buildDriving(member);
            drivingRepo.save(driving);
        }catch(Exception e){
            throw  new RuntimeException("Cannot add driving to the db",e);
        }
        return drivingDto;
    }

    @Override
    public void updateDriving(Long id, DrivingDto drivingDto) {
        Driving driving;
        try {
            Member member = memberRepo.getOne(id);
            driving = drivingDto.buildDriving(member);
            drivingRepo.updateByMemberId(member.getIdNUmber(),driving.getKm());
        }catch(Exception e){
            throw  new RuntimeException("Cannot update member driving to the db",e);
        }
    }
}
