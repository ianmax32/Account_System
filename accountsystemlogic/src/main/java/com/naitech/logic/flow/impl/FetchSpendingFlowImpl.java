package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.SpendingDto;
import com.naitech.logic.flow.FetchSpendingFlow;
import com.naitech.translator.SpendingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchSpendingFlowImpl implements FetchSpendingFlow {
    private final SpendingTranslator spendingTranslator;

    @Autowired
    public FetchSpendingFlowImpl(SpendingTranslator spendingTranslator) {
        this.spendingTranslator = spendingTranslator;
    }

    @Override
    public List<SpendingDto> fetchSpending() {
        List<SpendingDto> spendingDtos = new ArrayList<>();
        spendingDtos = spendingTranslator.getSpending();
        return null;
    }

    @Override
    public SpendingDto getMemberSpending(Long id) {
        SpendingDto spendingDto = spendingTranslator.getMemberSpending(id);
        return spendingDto;
    }

    @Override
    public void addMember(MemberDto spendingDto) {
        spendingTranslator.addMember(spendingDto);
    }

    @Override
    public void updateMemberSpending(Long id, SpendingDto spendingDto) {
        spendingTranslator.updateMemberSpending(id,spendingDto);
    }
}
