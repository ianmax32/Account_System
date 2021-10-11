package com.naitech.translator.impl;

import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.MemberTransactions;
import com.naitech.repository.persistence.AccountTypeRepo;
import com.naitech.repository.persistence.MemberRepo;
import com.naitech.repository.persistence.TransactionsRepo;
import com.naitech.translator.TransactionsTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionsTranslator {
    private final TransactionsRepo transactionsRepo;
    private final AccountTypeRepo accountTypeRepo;
    private final MemberRepo memberRepo;
    private final MembersTranslatorImpl membersTranslator;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionTranslatorImpl.class);


    @Autowired
    public TransactionTranslatorImpl(TransactionsRepo transactionsRepo, AccountTypeRepo accountTypeRepo, MemberRepo memberRepo, MembersTranslatorImpl membersTranslator) {
        this.transactionsRepo = transactionsRepo;
        this.accountTypeRepo = accountTypeRepo;
        this.memberRepo = memberRepo;
        this.membersTranslator = membersTranslator;
    }


    @Override
    public List<TransactionsDto> getTransactions() {
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        try {
            for(MemberTransactions memberTransactions : transactionsRepo.findAll()){
                transactionsDtos.add(new TransactionsDto(memberTransactions));
            }

            LOGGER.info("Transactions that have been added : {}",transactionsDtos);
        }catch(Exception e){
            throw new RuntimeException("Cannot get all transactions from the database",e);
        }
        return transactionsDtos;
    }

    @Override
    public TransactionsDto addTransaction(TransactionsDto transactionsDto) {
        MemberTransactions memberTransactions;
        try {
            AccountType accountType = accountTypeRepo.getAccountTypeUniqueName(transactionsDto.getAccountType());
            Member member = memberRepo.getID(transactionsDto.getMembername(), transactionsDto.getMemberSurname());
            memberTransactions = transactionsDto.buildTransaction(accountType,member);


            LOGGER.info("Transaction adding with member {} using the account type {} will make a transaction of {}",member,accountType,memberTransactions);
            membersTranslator.updateAmount(member.getIdNUmber(), transactionsDto);
            transactionsRepo.save(memberTransactions);
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

            LOGGER.info("Transactions for id {} are {}",id,transactionsDtos);
        }catch(Exception e){
            throw new RuntimeException("Cannot get transactions by id from the database",e);
        }
        return transactionsDtos;
    }
}
