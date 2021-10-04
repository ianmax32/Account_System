package com.naitech.translator.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.SpendingDto;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Spending;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.repository.persistence.SpendingRepo;
import com.naitech.translator.SpendingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpendingTranslatorImpl implements SpendingTranslator {
    private final SpendingRepo spendingRepo;
    private final MemberRepo memberRepo;

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

    @Override
    public SpendingDto addMember(MemberDto memberDto) {
        Spending spending;
        SpendingDto spendingDto = memberDto.getSpendingDto();
        try {
            Member member = memberRepo.getID(memberDto.getName(), memberDto.getSurname());
            spending = spendingDto.buildSpending(member);
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
            spendingRepo.updateByMemberId(member.getIdNUmber(),spending.getCurrent_amount_spent());
        }catch(Exception e){
            throw  new RuntimeException("Cannot update member driving to the db",e);
        }
    }
}
