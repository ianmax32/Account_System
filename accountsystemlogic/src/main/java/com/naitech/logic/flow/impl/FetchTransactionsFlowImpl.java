package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchTransactionsFlow;
import com.naitech.translator.MembersTranslator;
import com.naitech.translator.TransactionsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchTransactionsFlowImpl implements FetchTransactionsFlow {
    private final TransactionsTranslator translator;
    private final MembersTranslator membersTranslator;

    @Autowired
    public FetchTransactionsFlowImpl(TransactionsTranslator translator, MembersTranslator membersTranslator) {
        this.translator = translator;
        this.membersTranslator = membersTranslator;
    }




    @Override
    public List<TransactionsDto> fetchTransactions() {
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        transactionsDtos = translator.getTransactions();
        return transactionsDtos;
    }

    @Override
    public TransactionsDto addTransaction(TransactionsDto transactionsDto) {
        TransactionsDto transactionsDto1= translator.addTransaction(transactionsDto);
        return transactionsDto1;
    }

    @Override
    public List<TransactionsDto> getTransactionsById(Long id) {
        List<TransactionsDto> transactionsDtos = translator.getTransactionsById(id);
        return transactionsDtos;
    }

    @Override
    public void updateMemberAmount(Long id, TransactionsDto transactionsDto) {
        membersTranslator.updateAmount(id,transactionsDto);
    }
}
