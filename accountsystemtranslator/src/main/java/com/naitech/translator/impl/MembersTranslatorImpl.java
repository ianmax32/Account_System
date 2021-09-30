package com.naitech.translator.impl;

import com.naitech.domain.DTO.MemberDto;
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

    @Autowired
    public MembersTranslatorImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public List<MemberDto> getMembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for(Member member: memberRepo.findAll()){
                memberDtos.add(new MemberDto(member));
            }
        }catch(Exception e){
            throw  new RuntimeException("Cannot get info form database",e);
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
    public void addMember(MemberDto member) {
        try {
            Member member1 = new Member();

            member1.setName(member.getName());
            member1.setSurname(member.getSurname());
            member1.setDob(member.getDob());
            member1.setGender(member.getGender());
            member1.setPlays(member.getPlays());
            memberRepo.save(member1);
        }catch(Exception e){
            throw new RuntimeException("Cannot add to db",e);
        }
    }

    @Override
    public void removeMember(Long id) {
        try {
            if(memberRepo.existsById(id)){
                memberRepo.deleteById(id);
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot add to db",e);
        }
    }

    @Override
    public void updateMember(Long id) {
        Member member = memberRepo.getOne(id);
        try {
            memberRepo.save(member);
        }catch(Exception e){
            throw new RuntimeException("Cannot add to db",e);
        }
    }
}
