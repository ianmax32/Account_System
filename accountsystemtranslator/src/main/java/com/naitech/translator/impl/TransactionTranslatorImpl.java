package com.naitech.translator.impl;

import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.MemberTransactions;
import com.naitech.repository.persistence.AccountTypeRepo;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.repository.persistence.TransactionsRepo;
import com.naitech.translator.TransactionsTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionsTranslator {
    private final TransactionsRepo transactionsRepo;
    private final AccountTypeRepo accountTypeRepo;
    private final MemberRepo memberRepo;

    @Autowired
    public TransactionTranslatorImpl(TransactionsRepo transactionsRepo, AccountTypeRepo accountTypeRepo, MemberRepo memberRepo) {
        this.transactionsRepo = transactionsRepo;
        this.accountTypeRepo = accountTypeRepo;
        this.memberRepo = memberRepo;
    }




    @Override
    public List<TransactionsDto> getTransactions() {
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        try {
            for(MemberTransactions memberTransactions : transactionsRepo.findAll()){
                transactionsDtos.add(new TransactionsDto(memberTransactions));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get all transactions from the database",e);
        }
        return transactionsDtos;
    }

    @Override
    public TransactionsDto addTransaction(TransactionsDto transactionsDto) {
        MemberTransactions memberTransactions;
        try {
            AccountType accountType = accountTypeRepo.getAccountTypeUniqueName(transactionsDto.getAccountTypeDTO().getPlaceHolder());
            Member member = memberRepo.getID(transactionsDto.getMemberDto().getName(), transactionsDto.getMemberDto().getSurname());
            memberTransactions = transactionsDto.buildTransaction(accountType,member);
        }catch(Exception e){
            throw new RuntimeException("Cannot add a new transaction into the database",e);
        }
        return new TransactionsDto(memberTransactions);
    }

    @Override
    public List<TransactionsDto> getTransactionsById(Long id) {
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        try {
            for(MemberTransactions memberTransactions : transactionsRepo.getAllTransactions(id)){
                transactionsDtos.add(new TransactionsDto(memberTransactions));
            }
        }catch(Exception e){
            throw new RuntimeException("Cannot get transactions by id from the database",e);
        }
        return transactionsDtos;
    }
}
