package com.naitech.translator.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.SpendingDto;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Spending;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.repository.persistence.SpendingRepo;
import com.naitech.translator.SpendingTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpendingTranslatorImpl implements SpendingTranslator {
    private final SpendingRepo spendingRepo;
    private final MemberRepo memberRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(SpendingTranslatorImpl.class);


    @Autowired
    public SpendingTranslatorImpl(SpendingRepo spendingRepo, MemberRepo memberRepo) {
        this.spendingRepo = spendingRepo;
        this.memberRepo = memberRepo;
    }

    @Override
    public List<SpendingDto> getSpending() {
        List<SpendingDto> spendingDtos = new ArrayList<>();
        try {
            for(Spending spending: spendingRepo.findAll()){
                spendingDtos.add(new SpendingDto(spending));
            }
            LOGGER.info("Spending for all the registered members are {}", spendingDtos);
        }catch(Exception e){
            throw new RuntimeException("cannot get info forom db",e);
        }
        return spendingDtos;
    }

    @Override
    public SpendingDto getMemberSpending(Long id) {
        Spending spending = spendingRepo.getOne(id);
        LOGGER.info("Spending for a member with id {} is {}",id, spending);
        return new SpendingDto(spending);
    }

    @Override
    public SpendingDto addMember(MemberDto memberDto) {
        Spending spending;
        SpendingDto spendingDto = memberDto.getSpendingDto();
        try {
            Member member = memberRepo.getID(memberDto.getName(), memberDto.getSurname());
            LOGGER.info("Member searched by name {} and surname {} is {}",memberDto.getName(),memberDto.getSurname(),member);
            spending = spendingDto.buildSpending(member);
            LOGGER.info("Spending for the new member with id member dto of {} is {}",member, spending);
            spendingRepo.save(spending);
        }catch(Exception e){
            throw new RuntimeException("cannot add spending info into db",e);
        }
        return spendingDto;
    }

    @Override
    public void updateMemberSpending(Long id,SpendingDto spendingDto) {
        Spending spending;
        try {
            Member member = memberRepo.getOne(id);
            spending = spendingDto.buildSpending(member);
            LOGGER.info("Spending update for member with id  {} and the new spending value is {}",member.getIdNUmber(), spending.getCurrent_amount_spent());
            spendingRepo.updateByMemberId(member.getIdNUmber(),spending.getCurrent_amount_spent());
        }catch(Exception e){
            throw  new RuntimeException("Cannot update member driving to the db",e);
        }
    }
}
