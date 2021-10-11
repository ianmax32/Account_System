package com.naitech.translator;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.Member;

import java.util.*;

public interface MembersTranslator {
    List<MemberDto> getMembers();
    MemberDto getMember(Long id);
    MemberDto addMember(MemberDto member);
    void removeMember(Long id);
    //void updateMember(MemberDto memberDto);
    void updateMemberPlays(Long id);
    void updateAmount(Long id, TransactionsDto transactionsDto);
}
