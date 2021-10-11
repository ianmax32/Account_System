package com.naitech.logic.flow;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.Member;

import java.util.List;

public interface FetchMembersFlow {
    List<MemberDto> getAllMembers();
    MemberDto getMember(Long id);
    void addMember(MemberDto member);
    void removeMember(Long id);
    //void updateMember(MemberDto memberDto);
}
