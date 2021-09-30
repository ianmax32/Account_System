package com.naitech.translator.impl;

import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.Transactions;
import com.naitech.repository.persistence.TransactionsRepo;
import com.naitech.translator.TransactionsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionsTranslator {
    private final TransactionsRepo transactionsRepo;

    @Autowired
    public TransactionTranslatorImpl(TransactionsRepo transactionsRepo) {
        this.transactionsRepo = transactionsRepo;
    }

    @Override
    public List<TransactionsDto> getTransactions() {
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        try {
            for(Transactions transactions: transactionsRepo.findAll()){
                transactionsDtos.add(new TransactionsDto(transactions));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get info from the database",e);
        }
        return transactionsDtos;
    }
}
