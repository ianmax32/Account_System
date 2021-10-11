package com.naitech.translator.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.Member;
import com.naitech.repository.persistence.*;
import com.naitech.translator.MembersTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembersTranslatorImpl implements MembersTranslator {
    private final MemberRepo memberRepo;
    private final DrivingRepo drivingRepo;
    private final Health_fitness_repo health_fitness_repo;
    private final SpendingRepo spendingRepo;
    private final TransactionsRepo transactionsRepo;


    @Autowired
    public MembersTranslatorImpl(MemberRepo memberRepo, DrivingRepo drivingRepo, Health_fitness_repo health_fitness_repo, SpendingRepo spendingRepo, TransactionsRepo transactionsRepo) {
        this.memberRepo = memberRepo;
        this.drivingRepo = drivingRepo;
        this.health_fitness_repo = health_fitness_repo;
        this.spendingRepo = spendingRepo;
        this.transactionsRepo = transactionsRepo;
    }




    @Override
    public List<MemberDto> getMembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for(Member member: memberRepo.findAll()){
                updateMemberPlays(member.getIdNUmber());
                memberDtos.add(new MemberDto(member));
            }
        }catch(Exception e){
            throw  new RuntimeException("Cannot get members form database",e);
        }
        System.out.println(memberDtos.toString());
        return memberDtos;
    }

    @Override
    public MemberDto getMember(Long id) {
        Member member = memberRepo.getOne(id);
        return new MemberDto(member);
    }

    @Override
    public MemberDto addMember(MemberDto member) {
        try {
            Member member1 = new Member();
            member1.setIdNUmber(null);
            member1.setName(member.getName());
            member1.setSurname(member.getSurname());
            member1.setDob(member.getDob());
            member1.setGender(member.getGender());
            member1.setPlays(member.getPlays());
            memberRepo.save(member1);
        }catch(Exception e){
            throw new RuntimeException("Cannot add member to db",e);
        }
        return member;
    }

    @Override
    public void removeMember(Long id) {
        try {
            if(memberRepo.existsById(id)){
                memberRepo.deleteById(id);
                drivingRepo.deleteByMemberId(id);
                health_fitness_repo.deleteByMemberId(id);
                spendingRepo.deleteByMemberId(id);
                transactionsRepo.deleteByMemberId(id);
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot delete from the db",e);
        }
    }


    @Override
    public void updateMemberPlays(Long id) {
        double curValue = drivingRepo.getCurValueByMemberId(id);
        double goal = drivingRepo.getGoalToMeetDriving(id);

        double memberHFCur = health_fitness_repo.getCurHFValueByMemberId(id);
        double HFGoal= health_fitness_repo.getGoalToMeetHF(id);

        double memberSpending = spendingRepo.getCurSpendingValueByMemberId(id);
        double spendingGoal = spendingRepo.getGoalToMeetSpending(id);

        int plays = memberRepo.curMemberPlays(id);
        try {
            if(curValue == goal || memberHFCur==HFGoal || memberSpending==spendingGoal){
                plays++;
            }
            memberRepo.updateMemberPlaysCurr(id,plays);
        }catch(Exception e){
            throw new RuntimeException("Cannot update plays to db",e);
        }
    }

    @Override
    public void updateAmount(Long id, TransactionsDto transactionsDto) {
        double cur_amount = memberRepo.getCurrentAmount(id);
        try {
            if(transactionsDto.getTransactionName().equalsIgnoreCase("game")){
                cur_amount+= transactionsDto.getTransaction_amount();
                memberRepo.updateMemberAmount(id,cur_amount);
            }else{
                cur_amount-= transactionsDto.getTransaction_amount();
                memberRepo.updateMemberAmount(id,cur_amount);
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot update amount to db",e);
        }
    }
}
