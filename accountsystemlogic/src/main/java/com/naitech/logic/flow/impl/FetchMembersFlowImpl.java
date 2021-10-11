package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchMembersFlow;
import com.naitech.translator.MembersTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchMembersFlowImpl implements FetchMembersFlow {
    private final MembersTranslator membersTranslator;

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchMembersFlowImpl.class);

    @Autowired
    public FetchMembersFlowImpl(MembersTranslator membersTranslator) {
        this.membersTranslator = membersTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDtos= new ArrayList<>();
        memberDtos = membersTranslator.getMembers();
        LOGGER.info("Members that have been added into the member's entity is {}", memberDtos);
        return memberDtos;
    }

    @Override
    public MemberDto getMember(Long id) {
        MemberDto memberDto = membersTranslator.getMember(id);
        LOGGER.info("Member with id {} has this info {}",id, memberDto);
        return memberDto;
    }

    @Override
    public void addMember(MemberDto member) {
        membersTranslator.addMember(member);
        LOGGER.info("Member to be added into the member's entity is {}", member);
    }

    @Override
    public void removeMember(Long id) {
        membersTranslator.removeMember(id);
    }

}
