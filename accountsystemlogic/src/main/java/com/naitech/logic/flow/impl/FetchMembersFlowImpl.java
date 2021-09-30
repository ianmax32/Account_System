package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchMembersFlow;
import com.naitech.translator.MembersTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchMembersFlowImpl implements FetchMembersFlow {
    private final MembersTranslator membersTranslator;

    @Autowired
    public FetchMembersFlowImpl(MembersTranslator membersTranslator) {
        this.membersTranslator = membersTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDtos= new ArrayList<>();
        memberDtos = membersTranslator.getMembers();
        //memberDtos.add(new MemberDto("Ian","Masaga", LocalDate.now(),"Male",0));
        return memberDtos;
    }

    @Override
    public MemberDto getMember(Long id) {
        MemberDto memberDto = membersTranslator.getMember(id);
        return memberDto;
    }

    @Override
    public void addMember(MemberDto member) {
        membersTranslator.addMember(member);
    }

    @Override
    public void removeMember(Long id) {
        membersTranslator.removeMember(id);
    }

    @Override
    public void updateMember(Long id) {
        membersTranslator.updateMember(id);
    }
}
