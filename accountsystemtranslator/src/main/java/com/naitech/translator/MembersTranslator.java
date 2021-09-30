package com.naitech.translator;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Member;

import java.util.*;

public interface MembersTranslator {
    List<MemberDto> getMembers();
    MemberDto getMember(Long id);
    void addMember(MemberDto member);
    void removeMember(Long id);
    void updateMember(Long id);
}
